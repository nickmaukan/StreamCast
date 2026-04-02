package com.streamcast.app.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.streamcast.app.detection.DetectedVideo

class MainViewModel : ViewModel() {

    private val _detectedVideos = MutableLiveData<List<DetectedVideo>>(emptyList())
    val detectedVideos: LiveData<List<DetectedVideo>> = _detectedVideos

    private val _history = MutableLiveData<List<HistoryItem>>(emptyList())
    val history: LiveData<List<HistoryItem>> = _history

    fun setDetectedVideos(videos: List<DetectedVideo>) {
        _detectedVideos.value = videos
    }

    fun clearDetectedVideos() {
        _detectedVideos.value = emptyList()
    }

    fun addToHistory(url: String, title: String) {
        val current = _history.value?.toMutableList() ?: mutableListOf()
        current.add(0, HistoryItem(url, title, System.currentTimeMillis()))
        _history.value = current
    }

    data class HistoryItem(
        val url: String,
        val title: String,
        val timestamp: Long
    )
}
