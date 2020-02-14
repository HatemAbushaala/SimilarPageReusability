package com.test.reusability

import android.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout

import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast


class BarbersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val reusablePage = ReusablePage(this)
        reusablePage.orientation = LinearLayout.VERTICAL
        val linLayoutParam = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        setContentView(reusablePage, linLayoutParam)

        reusablePage.setTitle("Barber")

        var list = ArrayList<String>()
        list.add("barber a")
        list.add("barber b")
        list.add("barber c")


        var adp = ArrayAdapter<String>(this, R.layout.simple_list_item_1,list)
        reusablePage.setListView(adp,object : AdapterView.OnItemClickListener{
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(this@BarbersActivity,"item $position clicked ", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this@BarbersActivity,ServicesActivity::class.java))

            }
        });
    }
}
