package XxAbsSouza.alunoresponsvel_rm96229.viewmodel

import DicaModel
import XxAbsSouza.alunoresponsvel_rm96229.data.DicaDao
import XxAbsSouza.alunoresponsvel_rm96229.data.DicaDataBase
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DicasViewModel(application: Application) : AndroidViewModel(application) {

    private val dicaDao: DicaDao

    val dicasLiveData: LiveData<List<DicaModel>>

    init {
        val database = Room.databaseBuilder(
            getApplication(),
            DicaDataBase::class.java,
            "dicas_database"
        ).build()
        dicaDao = database.dicaDao()
        dicasLiveData = dicaDao.getAll()
    }
    fun addDica(titulo: String, descricao: String) {
        viewModelScope.launch(Dispatchers.IO) {
            DicaDao.insert(newDica)
        }
    }
    fun removeDica(dica: DicaModel) {
        viewModelScope.launch(Dispatchers.IO) {
            DicaDao.delete(dica)
        }
    }
}