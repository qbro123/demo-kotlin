package vnext.tuantq.examplekotlin.mvp

interface NewsPresenter {

    interface View {
        fun onLoading()
        fun onShow()
        fun onError(err: String)
    }

    interface Presenter {
        fun addNews(edtTitle: String, edtContent: String)
        fun deleteNews()
        fun updateNews()
        fun searchItemNews()
    }
}