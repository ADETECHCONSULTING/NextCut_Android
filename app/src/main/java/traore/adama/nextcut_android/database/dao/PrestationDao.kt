package traore.adama.nextcut_android.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import traore.adama.nextcut_android.database.model.Prestation


@Dao
interface PrestationDao : BaseDao<Prestation> {

    @Query("SELECT * FROM prestation")
    fun getAll(): LiveData<List<Prestation>>

    @Query("SELECT * FROM prestation where nextcuter_id = :nextcuterId")
    fun getPrestationsByNextcuter(nextcuterId: Long): LiveData<List<Prestation>>
}