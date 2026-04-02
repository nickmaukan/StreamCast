package com.streamcast.app.ui.history

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.streamcast.app.R
import com.streamcast.app.data.HistoryEntry
import java.text.SimpleDateFormat
import java.util.*

class HistoryAdapter(
    private val onItemClick: (HistoryEntry) -> Unit,
    private val onFavoriteClick: (HistoryEntry) -> Unit,
    private val onDeleteClick: (HistoryEntry) -> Unit
) : ListAdapter<HistoryEntry, HistoryAdapter.HistoryViewHolder>(HistoryDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_history, parent, false)
        return HistoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class HistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleText: TextView = itemView.findViewById(R.id.text_title)
        private val urlText: TextView = itemView.findViewById(R.id.text_url)
        private val dateText: TextView = itemView.findViewById(R.id.text_date)
        private val btnFavorite: ImageButton = itemView.findViewById(R.id.btn_favorite)
        private val btnDelete: ImageButton = itemView.findViewById(R.id.btn_delete)

        fun bind(entry: HistoryEntry) {
            titleText.text = entry.title
            urlText.text = entry.url
            dateText.text = formatDate(entry.timestamp)

            btnFavorite.setImageResource(
                if (entry.isFavorite) R.drawable.ic_favorite_filled
                else R.drawable.ic_favorite
            )

            btnFavorite.setOnClickListener { onFavoriteClick(entry) }
            btnDelete.setOnClickListener { onDeleteClick(entry) }
            itemView.setOnClickListener { onItemClick(entry) }
        }

        private fun formatDate(timestamp: Long): String {
            val sdf = SimpleDateFormat("MMM dd, HH:mm", Locale.getDefault())
            return sdf.format(Date(timestamp))
        }
    }

    class HistoryDiffCallback : DiffUtil.ItemCallback<HistoryEntry>() {
        override fun areItemsTheSame(oldItem: HistoryEntry, newItem: HistoryEntry) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: HistoryEntry, newItem: HistoryEntry) =
            oldItem == newItem
    }
}
