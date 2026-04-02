package com.streamcast.app.ui.cast

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.SeekBar
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.streamcast.app.R
import com.streamcast.app.cast.CastManager

class CastControlSheet : BottomSheetDialogFragment() {

    private var castManager: CastManager? = null

    private lateinit var btnPlay: ImageButton
    private lateinit var btnStop: ImageButton
    private lateinit var btnMute: ImageButton
    private lateinit var btnBack: ImageButton
    private lateinit var btnForward: ImageButton
    private lateinit var seekBar: SeekBar
    private lateinit var textPosition: TextView
    private lateinit var textDuration: TextView
    private lateinit var textTitle: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.sheet_cast_control, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        castManager = CastManager.getInstance(requireContext())

        bindViews(view)
        setupObservers()
        setupControls()
    }

    private fun bindViews(view: View) {
        btnPlay = view.findViewById(R.id.btn_play)
        btnStop = view.findViewById(R.id.btn_stop)
        btnMute = view.findViewById(R.id.btn_mute)
        btnBack = view.findViewById(R.id.btn_back)
        btnForward = view.findViewById(R.id.btn_forward)
        seekBar = view.findViewById(R.id.seek_bar)
        textPosition = view.findViewById(R.id.text_position)
        textDuration = view.findViewById(R.id.text_duration)
        textTitle = view.findViewById(R.id.text_title)
    }

    private fun setupObservers() {
        castManager?.isPlaying?.observe(viewLifecycleOwner) { isPlaying ->
            btnPlay.setImageResource(if (isPlaying) R.drawable.ic_pause else R.drawable.ic_play)
        }

        castManager?.currentPosition?.observe(viewLifecycleOwner) { position ->
            textPosition.text = formatDuration(position)
            seekBar.progress = position.toInt()
        }
    }

    private fun setupControls() {
        btnPlay.setOnClickListener {
            val isPlaying = castManager?.isPlaying?.value ?: false
            if (isPlaying) {
                castManager?.pause()
            } else {
                castManager?.play()
            }
        }

        btnStop.setOnClickListener {
            castManager?.stop()
            dismiss()
        }

        btnMute.setOnClickListener {
            // Toggle mute - simplified
        }

        btnBack.setOnClickListener {
            val current = castManager?.currentPosition?.value ?: 0L
            castManager?.seekTo(maxOf(0L, current - 10000))
        }

        btnForward.setOnClickListener {
            val current = castManager?.currentPosition?.value ?: 0L
            val duration = castManager?.duration?.value ?: 0L
            castManager?.seekTo(minOf(duration, current + 10000))
        }
    }

    private fun formatDuration(ms: Long): String {
        val seconds = (ms / 1000) % 60
        val minutes = (ms / (1000 * 60)) % 60
        return String.format("%02d:%02d", minutes, seconds)
    }
}
