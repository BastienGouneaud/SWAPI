package com.example.swapi

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.function.Consumer

class PeopleListViewHolder(itemView: View, private val PeopleConsumer : Consumer<People>) : RecyclerView.ViewHolder(itemView){
    var txtName : TextView = itemView.findViewById(R.id.txtName)
    var txtGender : TextView = itemView.findViewById(R.id.txtGender)
    var txtBirthYear : TextView = itemView.findViewById(R.id.txtBirthYear)

    lateinit var people: People

    init{
        itemView.setOnClickListener { PeopleConsumer?.accept(people)}
    }
}