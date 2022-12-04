package com.zain.hamiltonkotlin

import com.google.gson.Gson
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ConversionRates(
    @SerializedName("USD")
    @Expose
    var USD: Double,
    @SerializedName("AED")
    @Expose
    var AED: Double,
    @SerializedName("AFN")
    @Expose
    var AFN: Double,
    @SerializedName("ALL")
    @Expose
    var ALL: Double,
    @SerializedName("AMD")
    @Expose
    var AMD: Double,
    @SerializedName("ANG")
    @Expose
    var ANG: Double,
    @SerializedName("AOA")
    @Expose
    var AOA: Double,
    @SerializedName("ARS")
    @Expose
    var ARS: Double,
    @SerializedName("AUD")
    @Expose
    var AUD: Double,
    @SerializedName("AWG")
    @Expose
    var AWG: Double,
    @SerializedName("AZN")
    @Expose
    var AZN: Double,
    @SerializedName("BAM")
    @Expose
    var BAM: Double,
    @SerializedName("BBD")
    @Expose
    var BBD: Double,
    @SerializedName("BDT")
    @Expose
    var BDT: Double,
    @SerializedName("BGN")
    @Expose
    var BGN: Double,
    @SerializedName("BHD")
    @Expose
    var BHD: Double,
    @SerializedName("BIF")
    @Expose
    var BIF: Double,
    @SerializedName("BMD")
    @Expose
    var BMD: Double,
    @SerializedName("BND")
    @Expose
    var BND: Double,
    @SerializedName("BOB")
    @Expose
    var BOB: Double,
    @SerializedName("BRL")
    @Expose
    var BRL: Double,
    @SerializedName("BSD")
    @Expose
    var BSD: Double,
    @SerializedName("BTN")
    @Expose
    var BTN: Double,
    @SerializedName("BWP")
    @Expose
    var BWP: Double,
    @SerializedName("BYN")
    @Expose
    var BYN: Double,
    @SerializedName("BZD")
    @Expose
    var BZD: Double,
    @SerializedName("CAD")
    @Expose
    var CAD: Double,
    @SerializedName("CDF")
    @Expose
    var CDF: Double,
    @SerializedName("CHF")
    @Expose
    var CHF: Double,
    @SerializedName("CLP")
    @Expose
    var CLP: Double,
    @SerializedName("CNY")
    @Expose
    var CNY: Double,
    @SerializedName("COP")
    @Expose
    var COP: Double,
    @SerializedName("CRC")
    @Expose
    var CRC: Double,
    @SerializedName("CUP")
    @Expose
    var CUP: Double,
    @SerializedName("CVE")
    @Expose
    var CVE: Double,
    @SerializedName("CZK")
    @Expose
    var CZK: Double,
    @SerializedName("DJF")
    @Expose
    var DJF: Double,
    @SerializedName("DKK")
    @Expose
    var DKK: Double,
    @SerializedName("DOP")
    @Expose
    var DOP: Double,
    @SerializedName("DZD")
    @Expose
    var DZD: Double,
    @SerializedName("EGP")
    @Expose
    var EGP: Double,
    @SerializedName("ERN")
    @Expose
    var ERN: Double,
    @SerializedName("ETB")
    @Expose
    var ETB: Double,
    @SerializedName("EUR")
    @Expose
    var EUR: Double,
    @SerializedName("FJD")
    @Expose
    var FJD: Double,
    @SerializedName("FKP")
    @Expose
    var FKP: Double,
    @SerializedName("FOK")
    @Expose
    var FOK: Double,
    @SerializedName("GBP")
    @Expose
    var GBP: Double,
    @SerializedName("GEL")
    @Expose
    var GEL: Double,
    @SerializedName("GGP")
    @Expose
    var GGP: Double,
    @SerializedName("GHS")
    @Expose
    var GHS: Double,
    @SerializedName("GIP")
    @Expose
    var GIP: Double,
    @SerializedName("GMD")
    @Expose
    var GMD: Double,
    @SerializedName("GNF")
    @Expose
    var GNF: Double,
    @SerializedName("GTQ")
    @Expose
    var GTQ: Double,
    @SerializedName("GYD")
    @Expose
    var GYD: Double,
    @SerializedName("HKD")
    @Expose
    var HKD: Double,
    @SerializedName("HNL")
    @Expose
    var HNL: Double,
    @SerializedName("HRK")
    @Expose
    var HRK: Double,
    @SerializedName("HTG")
    @Expose
    var HTG: Double,
    @SerializedName("HUF")
    @Expose
    var HUF: Double,
    @SerializedName("IDR")
    @Expose
    var IDR: Double,
    @SerializedName("ILS")
    @Expose
    var ILS: Double,
    @SerializedName("IMP")
    @Expose
    var IMP: Double,
    @SerializedName("INR")
    @Expose
    var INR: Double,
    @SerializedName("IQD")
    @Expose
    var IQD: Double,
    @SerializedName("IRR")
    @Expose
    var IRR: Double,
    @SerializedName("ISK")
    @Expose
    var ISK: Double,
    @SerializedName("JEP")
    @Expose
    var JEP: Double,
    @SerializedName("JMD")
    @Expose
    var JMD: Double,
    @SerializedName("JOD")
    @Expose
    var JOD: Double,
    @SerializedName("JPY")
    @Expose
    var JPY: Double,
    @SerializedName("KES")
    @Expose
    var KES: Double,
    @SerializedName("KGS")
    @Expose
    var KGS: Double,
    @SerializedName("KHR")
    @Expose
    var KHR: Double,
    @SerializedName("KID")
    @Expose
    var KID: Double,
    @SerializedName("KMF")
    @Expose
    var KMF: Double,
    @SerializedName("KRW")
    @Expose
    var KRW: Double,
    @SerializedName("KWD")
    @Expose
    var KWD: Double,
    @SerializedName("KYD")
    @Expose
    var KYD: Double,
    @SerializedName("KZT")
    @Expose
    var KZT: Double
)



