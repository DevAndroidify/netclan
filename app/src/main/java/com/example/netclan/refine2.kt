package com.example.netclan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toolbar
import androidx.core.content.ContextCompat
import org.w3c.dom.Text

class refine2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_refine2)
        val spinner=findViewById<Spinner>(R.id.spinner)
        val options= arrayOf(
            "Available| Hey Let Us Connet",
            "Away | Stay Discrete And Watch",
            "Busy | Do Not Disturb| Will Catch Up Lately",
            "SOS|Emergency! Need Assistance!"
        )
        val refinebutton=findViewById<TextView>(R.id.refinebuttonon)
        val back=R.drawable.progressbutton
        refinebutton.setBackgroundResource(back)
        refinebutton.setOnClickListener {
            refinebutton.setTextColor(ContextCompat.getColor(this, android.R.color.white))
            refinebutton.setBackgroundResource(R.drawable.refinebuttonon)
        }
        val toolbar=findViewById<androidx.appcompat.widget.Toolbar>(R.id.refinetoolbar)
        setSupportActionBar(toolbar)
       val backarrow=findViewById<ImageView>(R.id.backarrow)
        backarrow.setOnClickListener {
          finish()
        }

        val adapter=ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,options)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter=adapter
    }
}