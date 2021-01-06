package vnext.tuantq.examplekotlin.database

import androidx.room.*
import vnext.tuantq.examplekotlin.entity.News


@Dao
interface RoomDao {

    //CRUD - create read update delete

    @Query("Select * from News")
    fun getNews() : List<News>

    @Insert(onConflict = OnConflictStrategy.REPLACE)//using when you want replace
    fun insertNews(vararg news: News)//vararg không giới hạn tham số

    @Delete
    fun deleteNews(news: News)

    @Update
    fun updateNews(news: News)

}