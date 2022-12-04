package com.zain.hamiltonkotlin.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.zain.hamiltonkotlin.*
import com.zain.hamiltonkotlin.databinding.BottomSheetCurrencyRatesBinding
import com.zain.hamiltonkotlin.vm.MainViewModel
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch
import kotlin.reflect.full.memberProperties


class CurrencyRatesBottomSheet : BottomSheetDialogFragment(), AdapterCurrency.ItemClickListener{

    private var binding: BottomSheetCurrencyRatesBinding? = null
    var inputOrOutput: String? = ""
    private val viewModel: MainViewModel by activityViewModels()
    val mapCurrencyRates = HashMap<String, Double>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.currencyRatesStateFlow.filterNotNull().collect { currencyRates ->
                        println("Currency Rates: " + currencyRates.conversion_rates)

                        ConversionRates::class.memberProperties.forEach { member ->
                            mapCurrencyRates.put(
                                member.name,
                                member.getter.call(currencyRates.conversion_rates) as Double
                            )
                        }

                        println("HASHMAP: " + mapCurrencyRates.toSortedMap())
                        binding!!.rvCurrencyRates.layoutManager = LinearLayoutManager(requireContext())
                        val adapter = AdapterCurrency(mapCurrencyRates.toSortedMap(), this@CurrencyRatesBottomSheet)
                        binding!!.rvCurrencyRates.adapter = adapter
                    }
                }
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.AppBottomSheetDialogTheme)

    }

    override fun dismiss() {
        super.dismiss()

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = BottomSheetCurrencyRatesBinding.inflate(inflater, container, false)
        viewModel.retrieveCurrencyRates()
        inputOrOutput = arguments?.getString("inputOrOutput")
        return binding!!.root
    }

    override fun onItemClick(position: Int, key: String, value: Double) {
        val navController = findNavController()
        inputOrOutput?.let { navController.previousBackStackEntry?.savedStateHandle?.set(it, key + value.toString()) }
        dismiss()
    }
}
