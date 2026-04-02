package com.streamcast.app.ui.videos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.streamcast.app.R
import com.streamcast.app.detection.DetectedVideo

class VideoAdapter(
    private val videos: List<DetectedVideo>,
    private val onVideoClick: (DetectedVideo) -> Unit
) : RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_detected_video, parent, false)
        return VideoViewHolder(view)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.bind(videos[position])
    }

    override fun getItemCount() = videos.size

    inner class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val cardView: CardView = itemView.findViewById(R.id.card_video)
        private val titleText: TextView = itemView.findViewById(R.id.text_title)
        private val badgeQuality: TextView = itemView.findViewById(R.id.badge_quality)
        private val badgeType: TextView = itemView.findViewById(R.id.badge_type)
        private val badgeLive: TextView = itemView.findViewById(R.id.badge_live)
        private val textDuration: TextView = itemView.findViewById(R.id.text_duration)
        private val iconType: ImageView = itemView.findViewById(R.id.icon_type)

        fun bind(video: DetectedVideo) {
            titleText.text = video.title.ifEmpty { "Video" }

            // Quality badge
            if (video.isLive) {
                badgeQuality.visibility = View.GONE
                badgeLive.visibility = View.VISIBLE
            } else {
                badgeQuality.visibility = View.VISIBLE
                badgeLive.visibility = View.GONE
                badgeQuality.text = video.resolution.ifEmpty { "SD" }
                badgeQuality.setBackgroundColor(getQualityColor(video.resolution))
            }

            // Type badge
            badgeType.text = video.format.ifEmpty { "MP4" }

            // Duration
            if (video.duration > 0 && !video.isLive) {
                textDuration.visibility = View.VISIBLE
                textDuration.text = formatDuration(video.duration.toLong())
            } else {
                textDuration.visibility = View.GONE
            }

            // Icon
            iconType.setImageResource(R.drawable.ic_video)

            // Click
            cardView.setOnClickListener {
                onVideoClick(video)
            }
        }

        private fun getQualityColor(quality: String): Int {
            return when (quality) {
                "4K", "2160p" -> ContextCompat.getColor(itemView.context, R.color.video_badge_hd)
                "1080p" -> ContextCompat.getColor(itemView.context, R.color.video_badge_hd)
                "720p" -> ContextCompat.getColor(itemView.context, R.color.primary)
                else -> ContextCompat.getColor(itemView.context, R.color.video_badge_sd)
            }
        }

        private fun formatDuration(seconds: Long): String {
            val minutes = seconds / 60
            val secs = seconds % 60
            return String.format("%02d:%02d", minutes, secs)
        }
    }
}
