package com.example.mvvmapp.data.model

import com.example.mvvmapp.utils.JSONConvertible
import com.google.gson.annotations.SerializedName

data class AcronymLfs(
    @SerializedName("vars")
    var vars: List<AcronymBaseLf>
) : JSONConvertible, AcronymBaseLf() {
    companion object {
        fun getEmptyAcronymLf(): AcronymLfs {
            return AcronymLfs(
                listOf(AcronymBaseLf())
            )
        }
    }
}