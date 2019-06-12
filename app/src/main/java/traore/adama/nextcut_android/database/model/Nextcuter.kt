package traore.adama.nextcut_android.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "nextcuter")
class Nextcuter(
    @PrimaryKey(autoGenerate = true) var id: Long?,
    @ColumnInfo(name = "price") var price: Int?,
    @ColumnInfo(name = "firstname") var firstname: String,
    @ColumnInfo(name = "lastname") var lastname: String,
    @ColumnInfo(name = "description") var description: String?,
    @ColumnInfo(name = "isFav") var isFav: Boolean = true
)
/*
class Nextcuter (
    @PrimaryKey(autoGenerate = true) var id: Long?,
    @ColumnInfo(name = "username") var username: String,
    @ColumnInfo(name = "firstname") var firstname: String,
    @ColumnInfo(name = "lastname") var lastname: String,
    @ColumnInfo(name = "description") var description: String?,
    @ColumnInfo(name = "price") var price: Double?,
    @ColumnInfo(name = "rating") var rating: Int = 0 //démarrage du rating à 0
)*/
