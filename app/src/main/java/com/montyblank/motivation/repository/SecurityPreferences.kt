package com.montyblank.motivation.repository

import android.content.Context

class SecurityPreferences(context: Context) {

    private val shared= context.getSharedPreferences("Motivation", Context.MODE_PRIVATE)


    fun storeString(key: String,value: String){

        shared.edit().putString(key, value).apply()
    }

    fun getStoreString(key: String): String{
        return shared.getString(key, "") ?: ""
    }
}