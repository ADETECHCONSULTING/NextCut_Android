package traore.adama.nextcut_android.database.dao

import android.arch.persistence.room.*

@Dao
interface BaseDao<T> {

    /**
     * Replace = OnConflict strategy constant to replace the old data and continue the transaction.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(obj: T)

    @Delete()
    fun delete(obj: T)

    @Update()
    fun update(obj: T)
}