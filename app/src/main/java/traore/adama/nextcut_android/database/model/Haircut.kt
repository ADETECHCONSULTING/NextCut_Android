package traore.adama.nextcut_android.database.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "haircut")
class Haircut(
    @PrimaryKey(autoGenerate = true) var id: Long?,
    @ColumnInfo(name = "url_image") var urlImage: String?,
    @ColumnInfo(name = "haircut_name") var haircutName: String
)