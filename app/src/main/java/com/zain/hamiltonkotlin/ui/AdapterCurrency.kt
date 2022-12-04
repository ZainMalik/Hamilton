package com.zain.hamiltonkotlin.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.trace
import androidx.recyclerview.widget.RecyclerView
import com.zain.hamiltonkotlin.R
import java.util.*

class AdapterCurrency(private val mapCurrencyRates: SortedMap<String, Double>,val mItemClickListener: ItemClickListener) :
    RecyclerView.Adapter<AdapterCurrency.ViewHolder>() {

    val arrayListNames = arrayListOf<String>()
    val arrayListValues = arrayListOf<Double>()

    interface ItemClickListener{
        fun onItemClick(position: Int, key: String, value: Double)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_currency, parent, false)

        mapCurrencyRates.forEach {
                (key, value) -> println("$key = $value")
            arrayListNames.add(key)
            arrayListValues.add(value)
        }

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.tvCurrencyName.text = arrayListNames.get(position)
        holder.tvCurrencyValue.text = arrayListValues.get(position).toString()

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mapCurrencyRates.size
    }

    // Holds the views for adding it to image and text
    inner class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        var tvCurrencyName: TextView = itemView.findViewById(R.id.tv_currency_name)
        var tvCurrencyValue: TextView = itemView.findViewById(R.id.tv_currency_value)

        init {
            ItemView.setOnClickListener{
                mItemClickListener.onItemClick(adapterPosition, arrayListNames.get(adapterPosition), arrayListValues.get(adapterPosition))
            }
        }
    }
}
