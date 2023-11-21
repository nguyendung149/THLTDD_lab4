package com.example.thltdd_lab4_fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class MyFragmentDetail():Fragment() {
    var text:String = ""
    val KEY_CONTENT:String = "MyFragmentDetail:Content"

    constructor(text:String):this(){
        this.text = text
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view :View = inflater.inflate(R.layout.my_fragment_detail_ver,null)
        (view.findViewById(R.id.tv_product_detail_ver) as TextView).text = this.text
        return view
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY_CONTENT,text)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if((savedInstanceState!=null) &&(savedInstanceState.containsKey(KEY_CONTENT))){
            text = savedInstanceState.getString(KEY_CONTENT) as String
        }
    }
}