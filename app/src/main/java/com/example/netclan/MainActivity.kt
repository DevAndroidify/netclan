package com.example.netclan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity() {
lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);
        val image=findViewById<ImageView>(R.id.menuholder)
        val toolbar=findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar);
        setSupportActionBar(toolbar);
        var drawerlayout:DrawerLayout=findViewById(R.id.drawerlayout)
        val navview:NavigationView=findViewById(R.id.navigation)
        toggle=ActionBarDrawerToggle(this,drawerlayout,R.string.open,R.string.close);
        drawerlayout.addDrawerListener(toggle)
        image.setOnClickListener {
            drawerlayout.openDrawer(GravityCompat.START)
            toggle.syncState()
        }

        var viewPager = findViewById<ViewPager>(R.id.viewpager)
        var tablayout = findViewById<TabLayout>(R.id.tablayout)

        val fragmentAdapter = viewpageadapter(supportFragmentManager)
        fragmentAdapter.addFragment(personal(),"PERSONAL")
        fragmentAdapter.addFragment(business(),"BUSINESS")
        fragmentAdapter.addFragment(mercent(),"MERCENT")

        viewPager.adapter = fragmentAdapter
        var refine=findViewById<ImageView>(R.id.refine)
        refine.setOnClickListener {
            var a=Intent(this,refine2::class.java)
            startActivity(a)
        }
        tablayout.setupWithViewPager(viewPager)
    }

}