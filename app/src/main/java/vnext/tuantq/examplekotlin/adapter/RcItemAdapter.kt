package vnext.tuantq.examplekotlin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import vnext.tuantq.examplekotlin.databinding.ItemRcCustomBinding
import vnext.tuantq.examplekotlin.entity.News

//data class truyền tham số vào
class RcItemAdapter(private val listItem: List<News>, private val clickItem: OnClickItem): RecyclerView.Adapter<RcItemAdapter.RcItemHolder>() {

    //khai báo ánh xạ item view bằng view binding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RcItemHolder {
        val binding = ItemRcCustomBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RcItemHolder(binding)
    }

    override fun onBindViewHolder(holder: RcItemHolder, position: Int) {
        //trả data lên view sử dụng view binding
        val item = holder.itemBinding
        val value = listItem[position]
        item.tvContent.text = value.content
        item.tvTime.text = value.time
        item.tvTitle.text = value.name
        item.root.setOnClickListener { clickItem.clickItem(value)}
    }

    //return kết quả size list trả về lên item recycle
    override fun getItemCount(): Int = listItem.size

    //data class xử lý view item
    class RcItemHolder(val itemBinding: ItemRcCustomBinding) : RecyclerView.ViewHolder(itemBinding.root)


    //using interface function when click item

}