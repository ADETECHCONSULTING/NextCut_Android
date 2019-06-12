package traore.adama.nextcut_android.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "haircut")
class Haircut(
    @PrimaryKey(autoGenerate = true) var id: Long?,
    @ColumnInfo(name = "url_image") var urlImage: String?,
    @ColumnInfo(name = "haircut_name") var haircutName: String
)