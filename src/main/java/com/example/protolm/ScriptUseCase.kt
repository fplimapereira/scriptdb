package com.example.protolm

import android.app.Application
import android.content.SharedPreferences

class ScriptUseCase(val app: Application) {
    private var PRIVATE_MODE = 0
    private val PREF_NAME = "personagem"
    private val sharedPref: SharedPreferences = app.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
    private val editor: SharedPreferences.Editor = sharedPref.edit()


    fun useCaseUm(){
        editor.putInt("vida", 18)



    }

}