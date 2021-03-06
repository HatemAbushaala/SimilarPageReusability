package com.test.reusability

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Toast

class ServicesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val reusablePage = ReusablePage(this)
        reusablePage.orientation = LinearLayout.VERTICAL
        val linLayoutParam = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        setContentView(reusablePage, linLayoutParam)

        reusablePage.setTitle("Services")

        var list = ArrayList<String>()
        list.add("1")
        list.add("2")
        list.add("3")
        list.add("4")
        list.add("5")

        var adp = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list)
        reusablePage.setListView(adp,object : AdapterView.OnItemClickListener{
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(this@ServicesActivity,"item $position clicked ", Toast.LENGTH_SHORT).show()
                var newPage = object : AppCompatActivity(){
                    override fun onCreate(savedInstanceState: Bundle?) {
                        super.onCreate(savedInstanceState)


                    }
                }


            }
        });

    }
}
