package com.streamcast.app.detection

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson

class VideoDetector {

    private val _detectedVideos = MutableLiveData<List<DetectedVideo>>(emptyList())
    val detectedVideos: LiveData<List<DetectedVideo>> = _detectedVideos

    private val videoSet = mutableSetOf<String>()

    private val VIDEO_EXTENSIONS = listOf(
        ".mp4", ".m3u8", ".webm", ".mkv", ".avi", ".mov", ".mpd", ".m4v", ".flv"
    )

    private val VIDEO_URL_PATTERNS = listOf(
        "videoplayback", "manifest.mpd", "master.m3u8", "index.m3u8",
        "chunklist", "/hls/", "/dash/", "mime=video", ".mp4?"
    )

    fun analyzeUrl(url: String, pageTitle: String, pageUrl: String) {
        val lower = url.lowercase()
        val isVideo = VIDEO_EXTENSIONS.any { lower.contains(it) } ||
                VIDEO_URL_PATTERNS.any { lower.contains(it) }

        if (isVideo && url.startsWith("http") && !videoSet.contains(url)) {
            videoSet.add(url)
            val video = DetectedVideo(
                url = url,
                title = extractTitle(url, pageTitle),
                format = detectFormat(url),
                resolution = guessResolution(url),
                contentType = guessContentType(url),
                source = "network",
                pageUrl = pageUrl,
                detectedAt = System.currentTimeMillis()
            )
            val current = _detectedVideos.value?.toMutableList() ?: mutableListOf()
            current.add(0, video)
            _detectedVideos.postValue(current)
        }
    }

    val scanPageJS = """
        (function() {
            var found = [];
            document.querySelectorAll('video').forEach(function(v) {
                if (v.src || v.currentSrc) {
                    found.push({
                        url: v.src || v.currentSrc,
                        title: v.title || v.getAttribute('aria-label') || document.title,
                        duration: v.duration ? Math.round(v.duration) : 0,
                        width: v.videoWidth || 0,
                        height: v.videoHeight || 0
                    });
                }
            });
            return JSON.stringify(found);
        })();
    """.trimIndent()

    fun processJsScanResult(json: String, pageTitle: String, pageUrl: String) {
        try {
            val array = Gson().fromJson(json, Array<JsVideoResult>::class.java)
            array?.forEach { jsVideo ->
                val url = jsVideo.url ?: return@forEach
                if (url.isNotEmpty() && !videoSet.contains(url)) {
                    videoSet.add(url)
                    val video = DetectedVideo(
                        url = url,
                        title = jsVideo.title?.ifEmpty { pageTitle } ?: pageTitle,
                        format = detectFormat(url),
                        resolution = if ((jsVideo.width ?: 0) > 0) "${jsVideo.width}x${jsVideo.height}" else guessResolution(url),
                        contentType = guessContentType(url),
                        source = "js-scan",
                        pageUrl = pageUrl,
                        duration = jsVideo.duration ?: 0,
                        detectedAt = System.currentTimeMillis()
                    )
                    val current = _detectedVideos.value?.toMutableList() ?: mutableListOf()
                    current.add(0, video)
                    _detectedVideos.postValue(current)
                }
            }
        } catch (e: Exception) {
            // Log error
        }
    }

    private fun detectFormat(url: String): String {
        val lower = url.lowercase()
        return when {
            lower.contains(".m3u8") -> "HLS"
            lower.contains(".mpd") -> "DASH"
            lower.contains(".mp4") -> "MP4"
            lower.contains(".webm") -> "WebM"
            else -> "Video"
        }
    }

    private fun guessResolution(url: String): String {
        val lower = url.lowercase()
        return when {
            lower.contains("2160") || lower.contains("4k") -> "4K"
            lower.contains("1080") -> "1080p"
            lower.contains("720") -> "720p"
            lower.contains("480") -> "480p"
            else -> ""
        }
    }

    private fun guessContentType(url: String): String {
        val lower = url.lowercase()
        return when {
            lower.contains(".m3u8") -> "application/x-mpegurl"
            lower.contains(".mpd") -> "application/dash+xml"
            lower.contains(".webm") -> "video/webm"
            else -> "video/mp4"
        }
    }

    private fun extractTitle(url: String, pageTitle: String): String {
        return try {
            val path = java.net.URI(url).path
            val filename = path.substringAfterLast("/").substringBeforeLast(".")
            if (filename.length > 3 && !filename.contains("index")) {
                filename.replace(Regex("[_-]"), " ").replaceFirstChar { it.uppercase() }
            } else {
                pageTitle.ifEmpty { "Video sin título" }
            }
        } catch (_: Exception) {
            pageTitle.ifEmpty { "Video sin título" }
        }
    }

    fun clearDetected() {
        videoSet.clear()
        _detectedVideos.value = emptyList()
    }

    data class JsVideoResult(
        val url: String?,
        val title: String?,
        val duration: Int?,
        val width: Int?,
        val height: Int?,
        val poster: String?
    )
}
