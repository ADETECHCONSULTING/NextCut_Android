package traore.adama.nextcut_android.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import traore.adama.nextcut_android.R
import traore.adama.nextcut_android.database.dao.HaircutDao
import traore.adama.nextcut_android.database.dao.NextcuterDao
import traore.adama.nextcut_android.database.model.Haircut
import traore.adama.nextcut_android.database.model.Nextcuter

@Database(entities = arrayOf(Haircut::class, Nextcuter::class), version = 2, exportSchema = true)
abstract class NextCutDatabase: RoomDatabase(){
    abstract fun haircutDao() : HaircutDao
    abstract fun nextcuterDao(): NextcuterDao

    /**
     * I should follow the singleton design pattern when instantiating a Database object, as each RoomDatabase
     * instance is fairly expensive, and you rarely need access to multiple instances.
     */
    companion object {
        private var INSTANCE: NextCutDatabase? = null

        fun getInstance(context: Context):NextCutDatabase?{
            if(INSTANCE == null){
                synchronized(NextCutDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        NextCutDatabase::class.java, context.getString(R.string.nextcut_db))
                        .build()
                }
            }

            return INSTANCE
        }

        fun destroyInstance(){
            INSTANCE = null
        }
    }
}