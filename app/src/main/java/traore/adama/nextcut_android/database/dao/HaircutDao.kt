package traore.adama.nextcut_android.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import traore.adama.nextcut_android.database.model.Haircut

@Dao
interface HaircutDao : BaseDao<Haircut> {

    @Query("SELECT * FROM haircut")
    fun getAll(): List<Haircut>

}