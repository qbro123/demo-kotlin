package vnext.tuantq.examplekotlin.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import vnext.tuantq.examplekotlin.entity.News


@Database(entities = [News::class], version = 1, exportSchema = false)

//using abstract class when create class room database
abstract class RoomDb : RoomDatabase() {

    //static - singleton
    companion object {
        private var roomDb: RoomDb? = null
        fun roomDbIntance(context: Context): RoomDb {
            if (roomDb == null) {
                //create room database
                roomDb = Room.databaseBuilder(
                    context,
                    RoomDb::class.java,
                    "demo.db")
                    .allowMainThreadQueries()
                    .build()
            }
            return roomDb as RoomDb
        }
    }

    abstract fun newsDao(): RoomDao

}