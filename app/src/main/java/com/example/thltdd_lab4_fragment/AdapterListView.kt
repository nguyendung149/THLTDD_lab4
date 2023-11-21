package com.example.thltdd_lab4_fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class AdapterListView constructor(
    var context: Context,
    var products: ArrayList<Product>,
    var inflater: LayoutInflater  = LayoutInflater.from(context)
) : BaseAdapter() {

    override fun getCount(): Int {
        return products.size
    }

    override fun getItem(p0: Int): Any {
        return products[p0]
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(p0: Int, convertView: View?, ViewGroup: ViewGroup?): View {
        var viewHolder: ViewHolder? = null
        var convertView = convertView
        if (convertView == null) {
            viewHolder = ViewHolder()
            convertView = inflater.inflate(R.layout.item_listview,null)
            viewHolder.imageView = (convertView as ImageView).findViewById(R.id.iv_product)
            viewHolder.textViewName = (convertView as TextView).findViewById(R.id.tv_name)
            viewHolder.textViewPrice = (convertView as TextView).findViewById(R.id.tv_price)
            convertView.setTag(viewHolder)

        }else {
            viewHolder = convertView.getTag() as ViewHolder
        }
        viewHolder.imageView.setBackgroundResource(products[p0].image)
        viewHolder.textViewName.setText(products[p0].name)
        viewHolder.textViewPrice.setText(products[p0].price)

        return convertView


    }

    private class ViewHolder constructor(

    ) {

        public lateinit var imageView: ImageView
        public lateinit var textViewName: TextView
        public lateinit var textViewPrice: TextView
    }
}