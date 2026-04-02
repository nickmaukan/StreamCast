package com.streamcast.app.ui.browser

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.streamcast.app.detection.DetectedVideo
import com.streamcast.app.detection.VideoDetector

class BrowserViewModel : ViewModel() {

    private val _currentUrl = MutableLiveData<String>("https://www.google.com")
    val currentUrl: LiveData<String> = _currentUrl

    private val _isLoading = MutableLiveData<Boolean>(false)
    val isLoading: LiveData<Boolean> = _isLoading

    val videoDetector = VideoDetector()

    fun setCurrentUrl(url: String) {
        _currentUrl.value = url
    }

    fun setLoading(loading: Boolean) {
        _isLoading.value = loading
    }
}
