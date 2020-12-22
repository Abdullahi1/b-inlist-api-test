package com.example.apitest.ui

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.apitest.R
import com.example.apitest.common.EventObserver
import com.example.apitest.common.showSnackWithAction
import com.example.apitest.databinding.HomeFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var binding: HomeFragmentBinding
    private lateinit var progressDialog: ProgressDialog


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HomeFragmentBinding.inflate(layoutInflater, container, false).apply {
            lifecycleOwner = this@HomeFragment
            viewModel = this@HomeFragment.viewModel
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressDialog = ProgressDialog(requireContext(), R.style.Widget_ProgressDialog).apply {
            setCancelable(false)
            setMessage(getString(R.string.loading))
        }
        subscribe()
    }

    private fun subscribe() {
        viewModel.internetResult.observe(viewLifecycleOwner, EventObserver {
            showSnackWithAction(
                message = "No active internet",
                view = requireView(),
                true,
                "Retry",
                action = {
                    viewModel.onButtonClicked()
                }
            )
        })

        viewModel.loading.observe(viewLifecycleOwner, EventObserver {
            if (it) {
                progressDialog.show()
            } else {
                progressDialog.dismiss()
            }
        })
    }

}