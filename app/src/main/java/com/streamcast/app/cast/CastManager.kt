package com.streamcast.app.cast

import android.content.Context
import android.net.wifi.WifiManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.mediarouter.media.MediaRouter

class CastManager private constructor(private val context: Context) {

    companion object {
        @Volatile
        private var instance: CastManager? = null
        fun getInstance(context: Context): CastManager {
            return instance ?: synchronized(this) {
                instance ?: CastManager(context.applicationContext).also { instance = it }
            }
        }
    }

    private var multicastLock: WifiManager.MulticastLock? = null

    // LiveData observables
    private val _castState = MutableLiveData<CastState>(CastState.DISCONNECTED)
    val castState: LiveData<CastState> = _castState

    private val _availableDevices = MutableLiveData<List<CastDevice>>(emptyList())
    val availableDevices: LiveData<List<CastDevice>> = _availableDevices

    private val _isPlaying = MutableLiveData<Boolean>(false)
    val isPlaying: LiveData<Boolean> = _isPlaying

    private val _currentPosition = MutableLiveData<Long>(0L)
    val currentPosition: LiveData<Long> = _currentPosition

    private val _duration = MutableLiveData<Long>(0L)
    val duration: LiveData<Long> = _duration

    private var currentVideoUrl: String = ""
    private var currentVideoTitle: String = ""

    data class CastDevice(val id: String, val name: String, val description: String)
    enum class CastState { DISCONNECTED, CONNECTING, CONNECTED, ERROR }

    fun initialize() {
        val wifi = context.getSystemService(Context.WIFI_SERVICE) as WifiManager
        multicastLock = wifi.createMulticastLock("StreamCast").apply {
            setReferenceCounted(true)
            acquire()
        }
    }

    fun refreshDevices() {
        val router = MediaRouter.getInstance(context)
        val devices = router.routes
            .filter { !it.isDefault && it.isEnabled }
            .filter { it.name != "Phone speaker" }
            .map { CastDevice(it.id, it.name, it.description?.toString() ?: "Device") }
        _availableDevices.postValue(devices)
    }

    fun connectToDevice(deviceId: String) {
        _castState.postValue(CastState.CONNECTING)
        val router = MediaRouter.getInstance(context)
        router.routes.find { it.id == deviceId }?.let { router.selectRoute(it) }
        _castState.postValue(CastState.CONNECTED)
    }

    fun castVideo(url: String, title: String, contentType: String) {
        currentVideoUrl = url
        currentVideoTitle = title
        _castState.postValue(CastState.CONNECTED)
        // Note: Full Cast SDK implementation would go here
        // This is a simplified version for demonstration
    }

    fun play() {
        _isPlaying.postValue(true)
    }

    fun pause() {
        _isPlaying.postValue(false)
    }

    fun stop() {
        _isPlaying.postValue(false)
        _currentPosition.postValue(0L)
    }

    fun seekTo(positionMs: Long) {
        _currentPosition.postValue(positionMs)
    }

    val isConnected: Boolean
        get() = _castState.value == CastState.CONNECTED

    fun destroy() {
        multicastLock?.let { if (it.isHeld) it.release() }
    }
}
