package com.example.mvvmapp.data.model

import com.example.mvvmapp.utils.JSONConvertible
import com.google.gson.annotations.SerializedName

data class Acronym(
    @SerializedName("sf")
    var sf: String,
    @SerializedName("lfs")
    var lsfs: List<AcronymLfs>,
) : JSONConvertible {
    companion object {
        fun getEmptyAcronym(): Acronym {
            return Acronym(
                "TEST", listOf(AcronymLfs.getEmptyAcronymLf())
            )
        }
    }
}