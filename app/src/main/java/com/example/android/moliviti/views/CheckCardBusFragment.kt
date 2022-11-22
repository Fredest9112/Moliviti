package com.example.android.moliviti.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.android.moliviti.databinding.CheckCardBusFragmentBinding
import com.example.android.moliviti.model.CardViewModel

class CheckBusCardFragment : Fragment() {

    private var binding: CheckCardBusFragmentBinding? = null
    private val cardViewModel: CardViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = CheckCardBusFragmentBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            viewModel = cardViewModel
            lifecycleOwner = viewLifecycleOwner
        }

        binding?.checkCardCharge?.setOnClickListener {
            val action =
                CheckBusCardFragmentDirections.actionCheckBusCardFragmentToRechargeCardBusFragment()
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}