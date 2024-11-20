package XxAbsSouza.alunoresponsvel_rm96229.data


import DicaModel
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [DicaModel::class], version = 1)
abstract class DicaDataBase : RoomDatabase() {
    abstract fun dicaDao(): DicaDao
}
