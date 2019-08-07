package com.example.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface EventosDao {

    @Insert
    fun insertEvento(e: Eventos)

    @Query("SELECT * FROM  eventos WHERE ponteiro = :id ")
    fun getScript(id: Int): Eventos

}