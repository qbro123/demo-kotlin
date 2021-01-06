package vnext.tuantq.examplekotlin.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class News(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "content") val content: String,
    @ColumnInfo(name = "time") val time: String,
) {
    constructor(name: String, content: String, time: String) : this(0, name, content, time)
}

