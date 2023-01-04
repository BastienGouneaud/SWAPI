package com.example.swapi

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.function.Consumer

class PeopleListViewHolder(itemView: View, private val PeopleConsumer : Consumer<People>) : RecyclerView.ViewHolder(itemView){
    var txtName : TextView = itemView.findViewById(R.id.txtName)
    lateinit var people: People

    init{
        itemView.setOnClickListener { PeopleConsumer?.accept(people)}
    }
}