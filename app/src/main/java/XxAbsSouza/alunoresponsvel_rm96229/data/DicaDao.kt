package XxAbsSouza.alunoresponsvel_rm96229.data

import DicaModel
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DicaDao {
        @Query("SELECT * FROM DicaModel")
        fun getAll(): LiveData<List<DicaModel>>
        @Insert
        fun insert(dica: DicaModel)
    }