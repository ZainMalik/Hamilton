package com.zain.hamiltonkotlin.ui

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.zain.hamiltonkotlin.R
import com.zain.hamiltonkotlin.databinding.FragmentConvertBinding
import com.zain.hamiltonkotlin.databinding.FragmentSuccessBinding
import com.zain.hamiltonkotlin.vm.MainViewModel
import java.text.DecimalFormat
import java.util.*


class SuccessFragment : Fragment(){

    private var binding: FragmentSuccessBinding? = null
    private val viewModel: MainViewModel by activityViewModels()
    private var inputCurrency: String = ""
    private var outputCurrency: String = ""
    private var inputCurrencyForRate: String = ""
    private var outputCurrencyForRate: String = ""


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding!!.ivForward.setOnClickListener { view ->
            if(findNavController().currentDestination?.id == R.id.success_fragment) {
                Navigation.findNavController(view)
                    .navigate(R.id.action_success_fragment_to_main_fragment)
            }
        }

        binding!!.tvTextAccount.text = "Great, now you have " + outputCurrency + " in your account."
        binding!!.tvTextRate.text = "Your conversion rate was " + outputCurrencyForRate + "/" + inputCurrencyForRate

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSuccessBinding.inflate(inflater, container, false)

        inputCurrency = arguments?.getString("input").toString()
        outputCurrency = arguments?.getString("output").toString()
        inputCurrencyForRate = arguments?.getString("inputCurrency").toString()
        outputCurrencyForRate = arguments?.getString("outputCurrency").toString()

        return binding!!.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if(findNavController().currentDestination?.id == R.id.success_fragment) {
                    view?.let {
                        Navigation.findNavController(it)
                            .navigate(R.id.action_success_fragment_to_main_fragment)
                    }
                }
            }
        })
    }

}
