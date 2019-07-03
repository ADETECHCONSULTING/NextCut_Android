package traore.adama.nextcut_android.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "prestation",
    foreignKeys = [
        ForeignKey(entity = Haircut::class,
            parentColumns = ["id"],
            childColumns = ["haircut_id"]),
        ForeignKey(entity = Nextcuter::class,
            parentColumns = ["id"],
            childColumns = ["nextcuter_id"])
    ])
class Prestation(
    @PrimaryKey(autoGenerate = true) var id: Long?,
    @ColumnInfo(name = "price") var price: Int?,
    @ColumnInfo(name = "haircut_id") var haircutId: Long?,
    @ColumnInfo(name = "nextcuter_id") var nextcuterId: Long?
)