package com.example.swapi

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.function.Consumer

class PlanetListViewHolder(itemView: View, private val PlanetConsumer : Consumer<Planet>) : RecyclerView.ViewHolder(itemView){
    var txtName : TextView = itemView.findViewById(R.id.txtName)
    lateinit var planet: Planet

    init{
        itemView.setOnClickListener { PlanetConsumer?.accept(planet)}
    }
}