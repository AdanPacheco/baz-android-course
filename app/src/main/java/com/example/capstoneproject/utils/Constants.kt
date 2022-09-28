package com.example.capstoneproject.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build

object Constants {


    const val ERROR_AVAILABLE_BOOK:String = "No se a podido recuperar la informacion de los libros disponibles"
    const val ERROR_TICKER:String = "No se a podido recuperar la informacion de detalle"
    const val ERROR_ORDER_BOOK :String ="No se a podido recuperar la informacion de las ordenes"
    const val EXTRA_KEY:String = "BOOK"
    const val URL_CRIPTO_ICONS :String = "https://assets.coincap.io/assets/icons/"
    const val EXT_CRIPTO_ICONS :String ="@2x.png"
    const val USER_AGENT_HEADER :String = "Wizeline-Project"
    const val USER_AGENT_VALUE :String = "Adan Pacheci"
    const val NAME_DATABASE:String = "bitso_database.db"
    const val URL_AVAILABLE_BOOKS:String = "available_books/"
    const val URL_TICKER:String = "ticker/"
    const val URL_ORDER_BOOK:String = "order_book/"


    fun isNetworkAvailable(context: Context?): Boolean {
        if (context == null) return false
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                when {
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                        return true
                    }
                }
            }
        } else {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                return true
            }
        }
        return false
    }
}