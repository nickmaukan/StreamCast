package com.streamcast.app.ui.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.streamcast.app.databinding.FragmentHistoryBinding
import com.streamcast.app.ui.main.MainViewModel

class HistoryFragment : Fragment() {

    private var _binding: FragmentHistoryBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.history.observe(viewLifecycleOwner) { history ->
            binding.emptyView.visibility = if (history.isEmpty()) View.VISIBLE else View.GONE
            binding.recyclerView.visibility = if (history.isEmpty()) View.GONE else View.VISIBLE
        }

        binding.btnClear.setOnClickListener {
            // Clear history
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
