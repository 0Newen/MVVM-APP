package com.example.mvvmapp.data.api

import com.example.mvvmapp.data.model.Acronym
import retrofit2.Call

class ApiServiceImpl:ApiService {

    override fun getAcronym(sf: String): Call<Acronym> {
        TODO("Not yet implemented")
    }
}