package com.streamcast.app.ui.browser

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.streamcast.app.R
import com.streamcast.app.databinding.FragmentBrowserBinding
import com.streamcast.app.detection.DetectedVideo
import com.streamcast.app.detection.VideoDetector
import com.streamcast.app.ui.main.MainActivity
import com.streamcast.app.ui.main.MainViewModel
import com.streamcast.app.ui.videos.DetectedVideosSheet

class BrowserFragment : Fragment() {

    private var _binding: FragmentBrowserBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var videoDetector: VideoDetector

    private var currentPageTitle = "Browser"
    private var currentPageUrl = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBrowserBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        videoDetector = VideoDetector()

        setupWebView()
        setupUrlBar()
        setupNavigation()
        setupVideoDetection()

        // Load default page
        if (savedInstanceState == null) {
            binding.webView.loadUrl("https://www.google.com")
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setupWebView() {
        binding.webView.apply {
            settings.apply {
                javaScriptEnabled = true
                domStorageEnabled = true
                mediaPlaybackRequiresUserGesture = false
                allowFileAccess = true
                allowContentAccess = true
                loadWithOverviewMode = true
                useWideViewPort = true
            }

            webViewClient = object : WebViewClient() {
                override fun shouldInterceptRequest(
                    view: WebView?,
                    request: WebResourceRequest?
                ): android.webkit.WebResourceResponse? {
                    request?.url?.toString()?.let { url ->
                        videoDetector.analyzeUrl(url, currentPageTitle, currentPageUrl)
                    }
                    return super.shouldInterceptRequest(view, request)
                }

                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                    super.onPageStarted(view, url, favicon)
                    currentPageUrl = url ?: ""
                    url?.let { binding.urlBar.setText(it) }
                }

                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    currentPageUrl = url ?: ""
                    currentPageTitle = view?.title ?: "Browser"

                    // Inject JS to scan for videos
                    view?.evaluateJavascript(videoDetector.scanPageJS) { result ->
                        if (result.isNotEmpty() && result != "null") {
                            videoDetector.processJsScanResult(result, currentPageTitle, currentPageUrl)
                        }
                    }

                    // Update navigation buttons
                    binding.btnBack.isEnabled = view?.canGoBack() == true
                    binding.btnForward.isEnabled = view?.canGoForward() == true

                    // Update title
                    view?.title?.let { title ->
                        if (title.isNotEmpty()) {
                            binding.titleBar.text = title
                        }
                    }
                }
            }

            webChromeClient = object : WebChromeClient() {
                override fun onProgressChanged(view: WebView?, newProgress: Int) {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.progressBar.progress = newProgress
                    if (newProgress == 100) {
                        binding.progressBar.visibility = View.GONE
                    }
                }

                override fun onReceivedTitle(view: WebView?, title: String?) {
                    super.onReceivedTitle(view, title)
                    title?.let { binding.titleBar.text = it }
                }
            }
        }
    }

    private fun setupUrlBar() {
        binding.urlBar.setOnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                var url = binding.urlBar.text.toString().trim()
                if (!url.startsWith("http://") && !url.startsWith("https://")) {
                    url = "https://$url"
                }
                binding.webView.loadUrl(url)
                binding.webView.requestFocus()
                true
            } else {
                false
            }
        }
    }

    private fun setupNavigation() {
        binding.btnBack.setOnClickListener {
            if (binding.webView.canGoBack()) {
                binding.webView.goBack()
            }
        }

        binding.btnForward.setOnClickListener {
            if (binding.webView.canGoForward()) {
                binding.webView.goForward()
            }
        }

        binding.btnRefresh.setOnClickListener {
            binding.webView.reload()
        }

        binding.btnHome.setOnClickListener {
            binding.webView.loadUrl("https://www.google.com")
        }

        binding.btnClear.setOnClickListener {
            videoDetector.clearDetected()
            viewModel.clearDetectedVideos()
            binding.urlBar.text.clear()
        }
    }

    private fun setupVideoDetection() {
        videoDetector.detectedVideos.observe(viewLifecycleOwner) { videos ->
            viewModel.setDetectedVideos(videos)
            updateVideoBadge(videos.size)

            // Show/hide FAB based on videos
            (activity as? MainActivity)?.showVideosFab(videos.isNotEmpty())
        }
    }

    private fun updateVideoBadge(count: Int) {
        if (count > 0) {
            binding.videoCount.visibility = View.VISIBLE
            binding.videoCount.text = count.toString()
        } else {
            binding.videoCount.visibility = View.GONE
        }
    }

    fun showDetectedVideos() {
        val videos = videoDetector.detectedVideos.value ?: return
        if (videos.isEmpty()) return

        val sheet = DetectedVideosSheet.newInstance(videos)
        sheet.onVideoSelected = { video ->
            (activity as? MainActivity)?.onVideoSelected(video)
        }
        sheet.show(parentFragmentManager, "videos_sheet")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
