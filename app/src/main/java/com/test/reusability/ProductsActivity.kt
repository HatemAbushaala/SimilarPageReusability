package com.test.reusability

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Toast


class ProductsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val reusablePage = ReusablePage(this)
        reusablePage.orientation = LinearLayout.VERTICAL
        val linLayoutParam = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        setContentView(reusablePage, linLayoutParam)

        reusablePage.setTitle("Products")

        var list = ArrayList<String>()
        list.add("a")
        list.add("b")
        list.add("c")
        list.add("d")
        list.add("e")

        var adp = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list)
        reusablePage.setListView(adp,object : AdapterView.OnItemClickListener{
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(this@ProductsActivity,"item $position clicked ", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this@ProductsActivity,ServicesActivity::class.java))

            }
        });

    }
}
