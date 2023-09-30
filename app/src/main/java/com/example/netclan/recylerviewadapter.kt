package com.example.netclan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class recylerviewadapter(var userlist:ArrayList<type>):RecyclerView.Adapter<recylerviewadapter.ViewHolder>() {

    fun setFilteredList(userlist: ArrayList<type>){
        this.userlist = userlist
        notifyDataSetChanged()
    }
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
       val name=itemView.findViewById<TextView>(R.id.name);
        val address=itemView.findViewById<TextView>(R.id.Adress);
        val distance=itemView.findViewById<TextView>(R.id.Distance);
        val progress=itemView.findViewById<ProgressBar>(R.id.progressBar);
        val hobbies=itemView.findViewById<TextView>(R.id.Hobbies);
        val carddata=itemView.findViewById<TextView>(R.id.carddata)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
     return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layoutlist,parent,false));

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val posi=userlist[position];
        holder.name.text=posi.name;
        holder.address.text=posi.address;
        holder.distance.text=posi.distance;
        holder.hobbies.text=posi.hobbies;
        holder.carddata.text=posi.carddata;
    }

    override fun getItemCount(): Int {
        return userlist.size
    }

}