package com.example.mvvmapp.data.api

import com.example.mvvmapp.data.model.Acronym
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(ApiConstant.GET_ACRONYM)
    fun getAcronym(@Query("sf") sf: String): Call<Acronym>
}