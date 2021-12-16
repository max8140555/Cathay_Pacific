package com.max.cathay_pacific.second

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.max.cathay_pacific.R
import com.max.cathay_pacific.databinding.FragmentSecondBinding

class SecondFragment : Fragment(R.layout.fragment_second) {

    companion object {
        fun newInstance() = SecondFragment()
    }

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSecondBinding.bind(view)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}