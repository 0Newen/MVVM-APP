package com.example.mvvmapp.data.model

import com.example.mvvmapp.utils.JSONConvertible
import com.google.gson.annotations.SerializedName

open class AcronymBaseLf(
    @SerializedName("lf")
    var lf: String = "",
    @SerializedName("freq")
    var freq: Int = -1,
    @SerializedName("since")
    var since: Int = -1
) : JSONConvertible {
    companion object{
        fun getEmptyAcronymLf():AcronymBaseLf{
            return AcronymBaseLf("",-1,-1)
        }
    }
}