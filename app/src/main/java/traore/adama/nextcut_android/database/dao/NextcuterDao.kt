package traore.adama.nextcut_android.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import traore.adama.nextcut_android.database.model.Nextcuter

@Dao
interface NextcuterDao : BaseDao<Nextcuter> {

    @Query("SELECT * FROM nextcuter")
    fun getAll(): LiveData<List<Nextcuter>>


}