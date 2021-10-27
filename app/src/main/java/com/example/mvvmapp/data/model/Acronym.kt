package com.example.mvvmapp.data.model

import com.example.mvvmapp.utils.JSONConvertible
import com.google.gson.annotations.SerializedName

class Acronym(
    @SerializedName("sf")
    var sf: String,
    @SerializedName("lsfs")
    var lsfs: List<AcronymLfs>,
) : JSONConvertible {
    companion object {
        fun getEmptyAcronym(): Acronym {
            return Acronym(
                "",
                listOf(AcronymLfs(listOf(AcronymBaseLf("",-1,-1))))
            )
        }
    }
}