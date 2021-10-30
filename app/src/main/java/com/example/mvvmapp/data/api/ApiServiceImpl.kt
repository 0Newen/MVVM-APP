package com.example.mvvmapp.data.api

import com.example.mvvmapp.data.model.Acronym
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Single

class ApiServiceImpl() : ApiService {

    override fun getAcronym(sf: String): Single<List<Acronym>> {
        return Rx2AndroidNetworking.get(ApiConstant.URL_BASE + ApiConstant.GET_ACRONYM + sf)
            .build()
            .getObjectListSingle(Acronym::class.java)
    }
}