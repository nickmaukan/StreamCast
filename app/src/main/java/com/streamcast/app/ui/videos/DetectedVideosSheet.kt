package com.streamcast.app.ui.videos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.streamcast.app.R
import com.streamcast.app.databinding.SheetDetectedVideosBinding
import com.streamcast.app.detection.DetectedVideo

class DetectedVideosSheet : BottomSheetDialogFragment() {

    private var _binding: SheetDetectedVideosBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: VideoAdapter
    private var videos: List<DetectedVideo> = emptyList()

    var onVideoSelected: ((DetectedVideo) -> Unit)? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SheetDetectedVideosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = VideoAdapter(videos) { video ->
            onVideoSelected?.invoke(video)
            dismiss()
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        binding.title.text = "${videos.size} video(s) detected"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(videos: List<DetectedVideo>): DetectedVideosSheet {
            return DetectedVideosSheet().apply {
                this.videos = videos
            }
        }
    }
}
