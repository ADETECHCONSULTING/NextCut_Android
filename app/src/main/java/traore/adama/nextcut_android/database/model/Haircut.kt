package traore.adama.nextcut_android.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "haircut")
class Haircut(
    @PrimaryKey(autoGenerate = true)
    @Json(name = "id")
    var id: Long?,

    @ColumnInfo(name = "url_image")
    @Json(name = "urlImage")
    var urlImage: String?,

    @ColumnInfo(name = "haircut_name")
    @Json(name = "haircutName")
    var haircutName: String
)