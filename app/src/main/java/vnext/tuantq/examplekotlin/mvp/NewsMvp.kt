package vnext.tuantq.examplekotlin.mvp

import vnext.tuantq.examplekotlin.database.RoomDb
import vnext.tuantq.examplekotlin.entity.News


class NewsMvp(private val view: NewsPresenter.View, private val roomDb: RoomDb): NewsPresenter.Presenter {

    override fun addNews(edtTitle: String, edtContent: String) {
        view.onLoading()
        roomDb.newsDao().insertNews(News(edtTitle,edtContent,"2 ngày trước"))
        view.onShow()
    }

    override fun deleteNews() {

    }

    override fun updateNews() {

    }

    override fun searchItemNews() {

    }
}