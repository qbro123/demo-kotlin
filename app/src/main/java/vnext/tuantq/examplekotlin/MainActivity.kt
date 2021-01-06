package vnext.tuantq.examplekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import vnext.tuantq.examplekotlin.adapter.OnClickItem
import vnext.tuantq.examplekotlin.adapter.RcItemAdapter
import vnext.tuantq.examplekotlin.database.RoomDb
import vnext.tuantq.examplekotlin.databinding.ActivityMainBinding
import vnext.tuantq.examplekotlin.databinding.DialogAddNewsBinding
import vnext.tuantq.examplekotlin.entity.News
import vnext.tuantq.examplekotlin.mvp.NewsMvp
import vnext.tuantq.examplekotlin.mvp.NewsPresenter
import vnext.tuantq.examplekotlin.utils.CustomToast
import kotlin.math.log

class MainActivity : AppCompatActivity(), View.OnClickListener, NewsPresenter.View, OnClickItem {

    private lateinit var binding: ActivityMainBinding
    private lateinit var dialog: AlertDialog
    private lateinit var roomDb: RoomDb
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        roomDb = RoomDb.roomDbIntance(this)
        binding.btnShowToast.setOnClickListener(this)
        initSetAdapter()
    }

    private fun initSetAdapter() {
        val adapter = RcItemAdapter(roomDb.newsDao().getNews(),this)
        binding.rcItem.adapter = adapter
        binding.rcItem.setHasFixedSize(true)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_show_toast -> {
                showAlertAdd(true)
            }
        }
    }



    private fun showAlertAdd(isChoose: Boolean) {
        val alertDialog = AlertDialog.Builder(this)
        val binding = DialogAddNewsBinding.inflate(layoutInflater)
        val mvp = NewsMvp(this, roomDb)
        binding.btnAddProduct.text = if(isChoose) "Thêm tin" else "Sửa tin"
        binding.btnAddProduct.setOnClickListener {
            if(binding.edtContent.text.isEmpty() || binding.edtTitle.text.isEmpty())
            onError("Vui lòng nhập đủ thông tin")
            else
            if(isChoose) mvp.addNews(binding.edtTitle.text.toString(),binding.edtContent.text.toString())
            else mvp.updateNews()
        }
        alertDialog.setView(binding.root)
        dialog = alertDialog.create()
        dialog.show()
    }

    override fun onLoading() {
        Log.d("onLoading", "onLoading")
    }

    override fun onShow() {
        dialog.dismiss()
        initSetAdapter()
    }

    override fun onError(err: String) {
        CustomToast.showMessage(this,err)
    }

    override fun clickItem(news: News) {

    }
}
