package com.test.reusability

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout

class Main : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var l = LinearLayout(this)
        var params = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        l.orientation = LinearLayout.VERTICAL

        var barbersBtn = Button(this)
        barbersBtn.text = "barbers"
        barbersBtn.setOnClickListener { openPage(BarbersActivity::class.java) }

        var productsBtn = Button(this)
        productsBtn.text = "products"
        productsBtn.setOnClickListener { openPage(ProductsActivity::class.java) }

        var servicesBtn = Button(this)
        servicesBtn.text = "services"
        servicesBtn.setOnClickListener { openPage(ServicesActivity::class.java) }

        l.addView(barbersBtn)
        l.addView(productsBtn)
        l.addView(servicesBtn)

        setContentView(l, params)
    }

    fun openPage(cls : Class<*> )
    {
        startActivity(Intent(this,cls))
    }
}
