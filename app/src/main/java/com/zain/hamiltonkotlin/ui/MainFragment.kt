package com.zain.hamiltonkotlin.ui

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.zain.hamiltonkotlin.R
import com.zain.hamiltonkotlin.databinding.FragmentMainBinding
import com.zain.hamiltonkotlin.vm.MainViewModel
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class MainFragment : Fragment(){

    private var binding: FragmentMainBinding? = null
    private val viewModel: MainViewModel by activityViewModels()
    private var inputCurrency: String = ""
    private var outputCurrency: String = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.currencyRatesStateFlow.filterNotNull().collect { currencyRates ->
                        Log.e("CurrencyRates: ", currencyRates.conversion_rates.toString()
                        )

                    }
                }
            }
        }

        binding!!.rlInputCurrency.setOnClickListener { view ->
            val bundle = Bundle()
            bundle.putString("inputOrOutput", "input")
            if(findNavController().currentDestination?.id == R.id.main_fragment) {
                Navigation.findNavController(view)
                    .navigate(R.id.action_main_fragment_to_bottom_sheet_currency_rates, bundle)
            }
        }

        binding!!.rlOutputCurrency.setOnClickListener { view ->
            val bundle = Bundle()
            bundle.putString("inputOrOutput", "output")
            if(findNavController().currentDestination?.id == R.id.main_fragment) {
                Navigation.findNavController(view)
                    .navigate(R.id.action_main_fragment_to_bottom_sheet_currency_rates, bundle)
            }
        }

        binding!!.tvCalculate.setOnClickListener { view ->
            val bundle = Bundle()
            bundle.putString("input", inputCurrency)
            bundle.putString("output", outputCurrency)
            bundle.putString("amount", binding!!.etAmount.text.toString())
            if(findNavController().currentDestination?.id == R.id.main_fragment) {
                Navigation.findNavController(view)
                    .navigate(R.id.action_main_fragment_to_convert, bundle)
            }
        }

        findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<String>("input")?.observe(viewLifecycleOwner) {
//            Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_SHORT).show()
            binding!!.tvInputCurrency.text = it.substring(0, 3)
            inputCurrency = it
        }

        findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<String>("output")?.observe(viewLifecycleOwner) {
//            Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_SHORT).show()
            binding!!.tvOutputCurrency.text = it.substring(0, 3)
            outputCurrency = it
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        viewModel.retrieveCurrencyRates()

        return binding!!.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}
