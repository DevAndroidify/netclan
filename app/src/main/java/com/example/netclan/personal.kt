package com.example.netclan

import android.content.ClipData.Item
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import java.util.*
import kotlin.collections.ArrayList


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [personal.newInstance] factory method to
 * create an instance of this fragment.
 */
class personal : Fragment() {

     private lateinit var userlist:ArrayList<type>
     private lateinit var recylerview:RecyclerView
    private lateinit var adapter:recylerviewadapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        userlist=ArrayList()

        // Inflate the layout for this fragment
       val  view=inflater.inflate(R.layout.fragment_personal,container,false)
recylerview=view.findViewById(R.id.recylerview)
        recylerview.layoutManager=LinearLayoutManager(context)
        userlist.add(type("Sagar Pandey","uran,islampur","WITHIN 5km",30,"playing footballs","SP"))
        userlist.add(type("Ajay Patil","uran,islampur","WITHIN 5km",30,"playing footballs","AP"))
        userlist.add(type("Hari Magar","uran,islampur","WITHIN 5km",30,"playing footballs","HM"))
        userlist.add(type("Suraj Ghimire","uran,islampur","WITHIN 5km",30,"playing footballs","SG"))

        adapter=recylerviewadapter(userlist)
        recylerview.adapter=adapter
        val searchView=view.findViewById<SearchView>(R.id.searchtext)

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }

        })
        return view
    }


    private fun filterList(query: String?) {

        if (query != null) {
            val filteredList = ArrayList<type>()
            for (i in userlist) {
                if (i.name.lowercase(Locale.ROOT).contains(query)) {
                    filteredList.add(i)
                }
            }

            if (filteredList.isEmpty()) {
            } else {
                adapter.setFilteredList(filteredList)
            }
        }
    }








}