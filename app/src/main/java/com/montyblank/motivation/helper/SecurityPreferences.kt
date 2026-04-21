package com.montyblank.motivation.helper

import android.content.Context

//sharedPreferences
//salvar informações > Chaves-Valor
//leves - mudam com pouca frequencia.
//Ex:Nome de usuário, senha, email.


//Banco de dados totalmente diferente de sharedPreferences.
//Armazenamento da informação, mas nã são iguais.

class SecurityPreferences(context: Context) {

    private val shared= context.getSharedPreferences("Motivation", Context.MODE_PRIVATE)


    fun storeString(key: String,value: String){

        shared.edit().putString(key, value).apply()
    }

    fun getString(key: String): String{
        return shared.getString(key, "") ?: ""
    }
}