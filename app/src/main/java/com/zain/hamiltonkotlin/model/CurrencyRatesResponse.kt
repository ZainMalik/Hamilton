package com.zain.hamiltonkotlin.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.zain.hamiltonkotlin.model.ConversionRates

data class CurrencyRatesResponse(
    @SerializedName("result")
    @Expose
    var result: String,
    @SerializedName("documentation")
    @Expose
    var documentation: String,
    @SerializedName("terms_of_use")
    @Expose
    var terms_of_use: String,
    @SerializedName("time_last_update_unix")
    @Expose
    var time_last_update_unix: Double,
    @SerializedName("time_last_update_utc")
    @Expose
    var time_last_update_utc: String,
    @SerializedName("time_next_update_unix")
    @Expose
    var time_next_update_unix: Double,
    @SerializedName("time_next_update_utc")
    @Expose
    var time_next_update_utc: String,
    @SerializedName("base_code")
    @Expose
    var base_code: String,
    @SerializedName("conversion_rates")
    @Expose
    var conversion_rates: ConversionRates
)
