package com.example.data

import androidx.room.Dao
import androidx.room.Query

@Dao
interface InimigosDao {

    @Query("SELECT * FROM  inimigos WHERE batalha_id = :batalhaId ")
    fun getBatalha(batalhaId: Int): Inimigos

}