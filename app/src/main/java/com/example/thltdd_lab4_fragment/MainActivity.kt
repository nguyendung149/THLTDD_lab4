package com.example.thltdd_lab4_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : FragmentActivity(),MyFragment.MyClickListener {
    lateinit var fragment:FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragment = supportFragmentManager
        var fragmentTransaction:FragmentTransaction = fragment.beginTransaction()
        fragmentTransaction.replace(R.id.container,MyFragment())
        fragmentTransaction.commit()
    }

    override fun click(product: Product) {
        var fragmentTransaction:FragmentTransaction = fragment.beginTransaction()
        fragmentTransaction.replace(R.id.container,MyFragmentDetail(product.description))
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

}