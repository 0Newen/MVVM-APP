package com.example.mvvmapp.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build

class Network {

    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork ?: return false
        val activeNetWork = connectivityManager.getNetworkCapabilities(network) ?: return false
        return when {
            activeNetWork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            activeNetWork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            activeNetWork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
    }
}