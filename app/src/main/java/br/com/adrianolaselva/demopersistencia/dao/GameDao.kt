package br.com.adrianolaselva.demopersistencia.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import br.com.adrianolaselva.demopersistencia.model.Game

@Dao
interface GameDao {

    @Insert
    fun inserir(game: Game)

    @Delete
    fun apagar(game: Game)

    @Update
    fun atualizar(game: Game)

    @Query("SELECT * FROM Game")
    fun lerGames(): LiveData<List<Game>>

    @Query("SELECT * FROM Game WHERE id = :id")
    fun buscarPorId(id: Int): Game

}