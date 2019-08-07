package com.example.testescript

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.data.Eventos
import com.example.data.EventosDao
import com.example.data.ScriptDataBase
import org.hamcrest.CoreMatchers.equalTo
import org.junit.After
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class DatabaseReadTest {
    private lateinit var eventoDao: EventosDao
    private lateinit var db: ScriptDataBase
    private val texto = "teste enredo"

    @Before
    fun createDB(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, ScriptDataBase::class.java)
            .build()

        eventoDao = db.eventosDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun readEvento(){

        val evento: Eventos =  Eventos(1, "teste enredo", "entrar", "sair",null, null, 35,
            null, null, null, null, null, null, 1, null)

        eventoDao.insertEvento(evento)

        val script = eventoDao.getScript(1)
        assertThat(script.evento, equalTo(texto))
    }
}