package traore.adama.nextcut_android.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import traore.adama.nextcut_android.database.model.Haircut

@Dao
interface HaircutDao : BaseDao<Haircut> {

    //Returning the LiveData wrapper around the
    //Member type automatically signals to Room that the query can/should be performed asynchronously
    @Query("SELECT * FROM haircut")
    fun getAll(): LiveData<List<Haircut>>

}