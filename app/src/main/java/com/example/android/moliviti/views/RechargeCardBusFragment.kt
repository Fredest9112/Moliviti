package com.example.android.moliviti.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.android.moliviti.R
import com.example.android.moliviti.databinding.RechargeCardBusFragmentBinding
import com.example.android.moliviti.model.CardViewModel

class RechargeCardBusFragment : Fragment() {

    private var binding: RechargeCardBusFragmentBinding? = null
    private val cardViewModel: CardViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = RechargeCardBusFragmentBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            viewModel = cardViewModel
            lifecycleOwner = viewLifecycleOwner
        }

        binding?.apply {
            cardViewModel.apply {
                rechargeCardCharge.setOnClickListener {
                    try {
                        setChargeValue(chargeValueInput.text.toString().toInt())
                        setNameValue(nameValueInput.text.toString())
                        setIdValue(idValueInput.text.toString().toLong())
                        setEmailValue(emailValueInput.text.toString())
                        if (checkFields()) {
                            when {
                                chargeValueInput.text.toString().toInt() < 9999 -> {
                                    resources.getString(R.string.wrong_values)
                                }
                                chargeValueInput.text.toString().toInt() > 300000 -> {
                                    resources.getString(R.string.wrong_values)
                                }
                                else -> {
                                    Toast.makeText(
                                        activity,
                                        resources.getString(R.string.good_values),
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    val action =
                                        RechargeCardBusFragmentDirections.actionRechargeCardBusFragmentToCheckBusCardFragment()
                                    findNavController().navigate(action)
                                }
                            }
                        } else {
                            Toast.makeText(
                                activity,
                                resources.getString(R.string.check_values),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    } catch (e: Exception) {
                        Toast.makeText(
                            activity,
                            resources.getString(R.string.error_values),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }

        binding?.apply {
            privacyCheckbox.setOnClickListener {
                when (privacyCheckbox.isChecked) {
                    true -> cardViewModel.checkPrivacyPolicy(true)
                    false -> cardViewModel.checkPrivacyPolicy(false)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}