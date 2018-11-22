package br.com.adrianolaselva.demopersistencia

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import br.com.adrianolaselva.demopersistencia.dao.BancoDeDados
import br.com.adrianolaselva.demopersistencia.model.Game

class ListaViewModel(application: Application) : AndroidViewModel(application) {

    private val db = BancoDeDados.getDatabase(application.applicationContext)

    var games: LiveData<List<Game>>? = null

    fun carregaGames() {
        games = db?.gameDao()?.lerGames()
    }

}