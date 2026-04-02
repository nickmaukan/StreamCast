package com.streamcast.app.detection

data class DetectedVideo(
    val url: String,
    val title: String,
    val format: String = "MP4",
    val resolution: String = "",
    val contentType: String = "video/mp4",
    val source: String = "unknown",
    val pageUrl: String = "",
    val thumbnail: String = "",
    val duration: Int = 0,
    val detectedAt: Long = System.currentTimeMillis()
) {
    val isLive: Boolean
        get() = url.contains("live") || url.contains("/live/") || contentType.contains("hls")
}
