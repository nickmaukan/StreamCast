package com.streamcast.app.ui.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.streamcast.app.R
import com.streamcast.app.cast.CastManager
import com.streamcast.app.databinding.ActivityMainBinding
import com.streamcast.app.ui.browser.BrowserFragment
import com.streamcast.app.ui.cast.CastControlSheet
import com.streamcast.app.ui.history.HistoryFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var castManager: CastManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Cast Manager
        castManager = CastManager.getInstance(this)
        castManager.initialize()

        setupBottomNavigation()
        setupFABs()
        observeCastState()

        // Load browser fragment by default
        if (savedInstanceState == null) {
            loadFragment(BrowserFragment())
        }
    }

    private fun setupBottomNavigation() {
        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_browser -> {
                    loadFragment(BrowserFragment())
                    true
                }
                R.id.nav_history -> {
                    loadFragment(HistoryFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun setupFABs() {
        binding.fabCast.setOnClickListener {
            when (castManager.castState.value) {
                CastManager.CastState.CONNECTED -> {
                    CastControlSheet().show(supportFragmentManager, "cast_control")
                }
                else -> {
                    showDevicePicker()
                }
            }
        }

        binding.fabVideos.setOnClickListener {
            val browserFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
            if (browserFragment is BrowserFragment) {
                browserFragment.showDetectedVideos()
            }
        }
    }

    private fun observeCastState() {
        castManager.castState.observe(this) { state ->
            when (state) {
                CastManager.CastState.CONNECTED -> {
                    binding.fabCast.setImageResource(R.drawable.ic_cast_connected)
                }
                else -> {
                    binding.fabCast.setImageResource(R.drawable.ic_cast)
                }
            }
        }

        viewModel.detectedVideos.observe(this) { videos ->
            binding.fabVideos.visibility = if (videos.isNotEmpty()) View.VISIBLE else View.GONE
        }
    }

    private fun loadFragment(fragment: androidx.fragment.app.Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    private fun showDevicePicker() {
        castManager.refreshDevices()
        val devices = castManager.availableDevices.value

        if (devices.isNullOrEmpty()) {
            Toast.makeText(this, R.string.no_devices, Toast.LENGTH_SHORT).show()
            return
        }

        val dialog = MaterialAlertDialogBuilder(this)
            .setTitle(R.string.select_device)
            .setItems(devices.map { it.name }.toTypedArray()) { _, which ->
                castManager.connectToDevice(devices[which].id)
            }
            .setNegativeButton(android.R.string.cancel, null)
            .create()
        dialog.show()
    }

    fun onVideoSelected(video: com.streamcast.app.detection.DetectedVideo) {
        if (castManager.isConnected) {
            castManager.castVideo(video.url, video.title, video.contentType)
            CastControlSheet().show(supportFragmentManager, "cast_control")
        } else {
            showDevicePicker()
        }
    }

    fun showVideosFab(show: Boolean) {
        binding.fabVideos.visibility = if (show) View.VISIBLE else View.GONE
    }

    override fun onDestroy() {
        super.onDestroy()
        if (::castManager.isInitialized) {
            castManager.destroy()
        }
    }
}
