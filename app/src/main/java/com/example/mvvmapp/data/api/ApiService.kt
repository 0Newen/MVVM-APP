package com.example.mvvmapp.data.api

import com.example.mvvmapp.data.model.Acronym
import io.reactivex.Single

interface ApiService {

    fun getAcronym(sf: String): Single<List<Acronym>>

}