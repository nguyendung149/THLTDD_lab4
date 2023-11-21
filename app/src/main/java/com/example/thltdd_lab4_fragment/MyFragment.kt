package com.example.thltdd_lab4_fragment

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment

class MyFragment():Fragment() {
    lateinit var products:ArrayList<Product>
    lateinit var clickListener:MyClickListener
    lateinit var textView:TextView


    public interface MyClickListener {
        public fun click(product: Product)
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view:View = inflater.inflate(R.layout.my_fragment_ver,null)
        products = ArrayList()
        var product1:Product = Product(
            "CoCa-CoLa",
            "Giá: 165.000/Thùng",
            "Bảo hành: 12 tháng. \r\n Nguồn gốc: Chính hãng. \r\n " +
                    "Hãng sản xuất: CoCa-CoLa. \r\n Dung tich(ml)/lon: 330.  \r\n Xuất xứ: Việt Nam",
            R.drawable.cocacola,1)
        var product2:Product = Product(
            "Pepsi",
            "Giá: 160.000/Thùng",
            "Bảo hành: 12 tháng. \r\n Nguồn gốc: Chính hãng. \r\n " +
                    "Hãng sản xuất: Pepsi. \r\n Dung tich(ml)/lon: 330.  \r\n Xuất xứ: Việt Nam",
            R.drawable.pepsi,1)
        var product3:Product = Product(
            "Sửa Đậu Nành",
            "Giá: 140.000/Thùng",
            "Bảo hành: 6 tháng. \r\n Nguồn gốc: Chính hãng. \r\n " +
                    "Hãng sản xuất: Sữa. \r\n Dung tich(ml)/lon: 440.  \r\n Xuất xứ: Việt Nam",
            R.drawable.suadaunhanh,2)
        var product4:Product = Product(
            "7up",
            "Giá: 155.000/Thùng",
            "Bảo hành: 6 tháng. \r\n Nguồn gốc: Chính hãng. \r\n " +
                    "Hãng sản xuất: 7up. \r\n Dung tich(ml)/lon: 330.  \r\n Xuất xứ: Việt Nam",
            R.drawable.pepsi,1)
        products.add(product1)
        products.add(product2)
        products.add(product3)
        products.add(product4)
        var listView:ListView = view.findViewById(R.id.lv_product_ver) as ListView
        textView = view.findViewById(R.id.tv_product_detail_ver) as TextView
        listView.adapter = AdapterListView(activity as Context,products)
        listView.setOnItemClickListener { adapterView, view, i, l ->

                if(textView==null){
                    clickListener = activity as MyClickListener
                    clickListener.click(products.get(i))
                }else {
                    textView.text = products.get(i).description.toString()
                }

        }
    return view
    }
}