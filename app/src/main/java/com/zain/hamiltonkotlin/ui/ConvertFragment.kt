package com.zain.hamiltonkotlin.ui

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.zain.hamiltonkotlin.R
import com.zain.hamiltonkotlin.databinding.FragmentConvertBinding
import java.text.DecimalFormat

class ConvertFragment : Fragment(){

    private var binding: FragmentConvertBinding? = null
    private var inputCurrency: String = ""
    private var outputCurrency: String = ""
    private var amount: String = ""
    private var conversion: Double = 0.0
    private val decimalFormat: DecimalFormat = DecimalFormat("0.00")


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        object : CountDownTimer(30000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding!!.tvTimer.text = ((millisUntilFinished / 1000).toString() + " sec left")
            }

            override fun onFinish() {
                if(findNavController().currentDestination?.id == R.id.convert_fragment) {
                    Navigation.findNavController(view)
                        .navigateUp()
                }
            }
        }.start()

        if(amount.toDouble() < conversion) {
            binding!!.tvFirstCurrency.text = amount + " " + inputCurrency.substring(0, 3)
            binding!!.tvLastCurrency.text =
                decimalFormat.format(conversion).toString() + " " + outputCurrency.substring(0, 3)
        } else {
            binding!!.tvLastCurrency.text = amount + " " + inputCurrency.substring(0, 3)
            binding!!.tvFirstCurrency.text =
                decimalFormat.format(conversion).toString() + " " + outputCurrency.substring(0, 3)
        }

        binding!!.tvConvert.setOnClickListener { view ->
            val bundle = Bundle()
            bundle.putString("input", amount + " " + inputCurrency.substring(0, 3))
            bundle.putString("inputCurrency", inputCurrency.substring(3))
            bundle.putString("output", decimalFormat.format(conversion).toString() + " " + outputCurrency.substring(0, 3) )
            bundle.putString("outputCurrency", outputCurrency.substring(3))
            if(findNavController().currentDestination?.id == R.id.convert_fragment) {
                Navigation.findNavController(view)
                    .navigate(R.id.action_convert_fragment_to_approve_fragment, bundle)
            }
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentConvertBinding.inflate(inflater, container, false)

        inputCurrency = arguments?.getString("input").toString()
        outputCurrency = arguments?.getString("output").toString()
        amount = arguments?.getString("amount").toString()

        conversion = outputCurrency.substring(3).toDouble() / inputCurrency.substring(3).toDouble()
        conversion = conversion.times(amount.toDouble())

        return binding!!.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}
