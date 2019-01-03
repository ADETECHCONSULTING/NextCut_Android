package traore.adama.nextcut_android.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import traore.adama.nextcut_android.database.dao.HaircutDao
import traore.adama.nextcut_android.database.model.Haircut

@Database(entities = arrayOf(Haircut::class), version = 1)
abstract class NextCutDatabase: RoomDatabase(){
    abstract fun haircutDao() : HaircutDao


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
                        NextCutDatabase::class.java, "haircut.db")
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