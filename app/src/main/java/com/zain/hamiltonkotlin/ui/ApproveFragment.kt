package com.zain.hamiltonkotlin.ui

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.zain.hamiltonkotlin.R
import com.zain.hamiltonkotlin.databinding.FragmentApproveBinding
import com.zain.hamiltonkotlin.databinding.FragmentConvertBinding
import com.zain.hamiltonkotlin.vm.MainViewModel
import java.text.DecimalFormat
import java.util.*


class ApproveFragment : Fragment(){

    private var binding: FragmentApproveBinding? = null
    private var inputCurrency: String = ""
    private var outputCurrency: String = ""
    private var inputCurrencyForRate: String = ""
    private var outputCurrencyForRate: String = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        object : CountDownTimer(30000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding!!.tvTimer.text = ((millisUntilFinished / 1000).toString() + " sec left")
            }

            override fun onFinish() {
                if(findNavController().currentDestination?.id == R.id.approve_fragment) {
                    Navigation.findNavController(view)
                        .navigate(R.id.action_approve_fragment_to_main_fragment)
                }
            }
        }.start()

        binding!!.tvCancel.setOnClickListener { view ->
            if(findNavController().currentDestination?.id == R.id.approve_fragment) {
                Navigation.findNavController(view)
                    .navigate(R.id.action_approve_fragment_to_main_fragment)
            }
        }

        binding!!.tvApprove.setOnClickListener { view ->
            val bundle = Bundle()
            bundle.putString("input", inputCurrency)
            bundle.putString("output", outputCurrency)
            bundle.putString("inputCurrency", inputCurrencyForRate)
            bundle.putString("outputCurrency", outputCurrencyForRate)
            if(findNavController().currentDestination?.id == R.id.approve_fragment) {
                Navigation.findNavController(view)
                    .navigate(R.id.action_approve_fragment_to_success_fragment, bundle)
            }
        }

        binding!!.tvText.text = "You are about to get " + outputCurrency + " for " + inputCurrency + ". Do you approve this transaction?"

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentApproveBinding.inflate(inflater, container, false)

        inputCurrency = arguments?.getString("input").toString()
        inputCurrencyForRate = arguments?.getString("inputCurrency").toString()
        outputCurrency = arguments?.getString("output").toString()
        outputCurrencyForRate = arguments?.getString("outputCurrency").toString()


        return binding!!.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}
