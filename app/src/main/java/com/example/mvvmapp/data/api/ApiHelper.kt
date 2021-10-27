package com.example.mvvmapp.data.api

class ApiHelper(private val apiService: ApiService) {

    fun getAcronym(sf: String) = apiService.getAcronym(sf = sf)

}