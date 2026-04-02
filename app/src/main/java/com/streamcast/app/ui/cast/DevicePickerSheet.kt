package com.streamcast.app.ui.cast

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.streamcast.app.R
import com.streamcast.app.databinding.SheetDevicePickerBinding

class DevicePickerSheet : BottomSheetDialogFragment() {

    private var _binding: SheetDevicePickerBinding? = null
    private val binding get() = _binding!!

    var onDeviceSelected: ((String) -> Unit)? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SheetDevicePickerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup will be completed with Cast SDK integration
        binding.textStatus.text = getString(R.string.scanning_devices)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
