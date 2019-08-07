package com.example.data

import androidx.room.Dao
import androidx.room.Query

@Dao
interface ItensDao {

    @Query("SELECT * FROM  itens WHERE item_id = :itemId ")
    fun getItens(itemId: Int): Itens

}