package com.example.mvvmapp.data.repository

import com.example.mvvmapp.data.api.ApiHelper
import com.example.mvvmapp.data.model.Acronym
import io.reactivex.Single
import retrofit2.Call

class MainRepository(private val apiHelper: ApiHelper) {

    fun getAcronym(sf: String): Single<List<Acronym>> {
        return apiHelper.getAcronym(sf)
    }

}