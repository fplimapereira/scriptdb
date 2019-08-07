package com.example.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Eventos::class, Inimigos::class, Itens::class], version = 1)
abstract class ScriptDataBase : RoomDatabase(){

    abstract fun eventosDao(): EventosDao
    abstract fun inimigosDao(): InimigosDao
    abstract fun itensDao(): ItensDao

    companion object {
        @Volatile
        private var INSTANCE: ScriptDataBase? = null

        fun getInstance(context: Context): ScriptDataBase{
            synchronized(this){
                var instance = INSTANCE

                if(instance == null){
                    instance = Room.databaseBuilder(context.applicationContext,
                        ScriptDataBase::class.java,"bancolm" )
                        .fallbackToDestructiveMigration()
                        .createFromAsset("bancolm.db")
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}