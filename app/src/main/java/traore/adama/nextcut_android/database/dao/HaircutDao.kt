package traore.adama.nextcut_android.database.dao

import androidx.room.Dao
import androidx.room.Query
import traore.adama.nextcut_android.database.model.Haircut

@Dao
interface HaircutDao : BaseDao<Haircut> {

    @Query("SELECT * FROM haircut")
    fun getAll(): List<Haircut>

}