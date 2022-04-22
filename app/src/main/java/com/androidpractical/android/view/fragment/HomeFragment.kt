package com.androidpractical.android.view.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.androidpractical.android.adapter.GridViewAdapter
import com.androidpractical.android.databinding.FragmentHomeBinding
import com.androidpractical.android.factory.HomeViewModelFactory
import com.androidpractical.android.server.ApiHelper
import com.androidpractical.android.server.RetrofitBuilder
import com.androidpractical.android.server.Status
import com.androidpractical.android.viewmodel.HomeViewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: HomeViewModel
    private lateinit var adapter: GridViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(
            this, HomeViewModelFactory(ApiHelper(RetrofitBuilder.api))
        )[HomeViewModel::class.java]

        setupObservers()

    }

    private fun setupObservers() {
        viewModel.getRootData().observe(viewLifecycleOwner) {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> resource.data?.let { coinList ->
                        coinList.dataModel?.listModels?.let { listModels ->
                            viewModel.mList = listModels
                        }

                        adapter = GridViewAdapter(context, viewModel.mList)
                        binding.gridView.adapter = adapter

                        binding.loading.visibility = View.GONE
                    }
                    Status.ERROR -> Toast.makeText(
                        context,
                        "Error " + it.message,
                        Toast.LENGTH_LONG
                    ).show()
                    Status.LOADING -> {
                        binding.loading.visibility = View.VISIBLE
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}