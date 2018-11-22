package br.com.adrianolaselva.demopersistencia.dao

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import br.com.adrianolaselva.demopersistencia.model.Game

@Database(entities = arrayOf(Game::class), version = 21)
abstract class BancoDeDados: RoomDatabase() {

    abstract fun gameDao(): GameDao

    companion object {

        var INSTANCE: BancoDeDados? = null

        fun getDatabase(context: Context): BancoDeDados? {
            if(INSTANCE == null){
                INSTANCE = Room.databaseBuilder(context.applicationContext,
                    BancoDeDados::class.java,
                    "games")
                    .build()
            }

            return INSTANCE
        }

    }

}