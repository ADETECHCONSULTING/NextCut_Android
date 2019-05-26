package traore.adama.nextcut_android.database.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import traore.adama.nextcut_android.database.model.Nextcuter

@Dao
interface NextcuterDao : BaseDao<Nextcuter> {

    @Query("SELECT * FROM nextcuter")
    fun getAll(): LiveData<List<Nextcuter>>

    //Select all favorites
    @Query("SELECT * FROM nextcuter WHERE isFav = 1")
    fun getAllFavorites():LiveData<List<Nextcuter>>
}