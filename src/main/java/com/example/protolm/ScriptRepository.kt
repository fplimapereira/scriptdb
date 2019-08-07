package com.example.protolm

import android.app.Application
import android.content.SharedPreferences
import com.example.data.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ScriptRepository(val app: Application) {

    private val eventoDao: EventosDao = ScriptDataBase.getInstance(app).eventosDao()
    private val itemDao: ItensDao = ScriptDataBase.getInstance(app).itensDao()
    private val inimigoDao: InimigosDao = ScriptDataBase.getInstance(app).inimigosDao()



     suspend fun getEvento(id: Int): Eventos?{
        return eventoDao.getScript(id)
    }










    fun aplicarEfeito(id: Int) {

    }
}