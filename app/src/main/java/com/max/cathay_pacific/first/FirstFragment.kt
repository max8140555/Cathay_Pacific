package com.max.cathay_pacific.first

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.max.cathay_pacific.R
import com.max.cathay_pacific.databinding.FragmentFirstBinding

class FirstFragment : Fragment(R.layout.fragment_first) {

    companion object {
        fun newInstance() = FirstFragment()
    }

    private lateinit var viewModel: FirstViewModel

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private val calendarAdapter by lazy {
        CalendarAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFirstBinding.bind(view)
        viewModel = ViewModelProvider(this)[FirstViewModel::class.java]

        initRecyclerView()
        observeViewModel()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun initRecyclerView() {
        binding.recyclerViewCalendar.adapter = calendarAdapter
    }

    private fun observeViewModel() {
        viewModel.items.observe(viewLifecycleOwner, {
            calendarAdapter.submitList(it)
        })
    }
}