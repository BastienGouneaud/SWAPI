package com.example.swapi

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.function.Consumer

class VehiclesListViewHolder(itemView: View, private val VehicleConsumer : Consumer<Vehicle>) : RecyclerView.ViewHolder(itemView){
    var txtName : TextView = itemView.findViewById(R.id.txtName)
    lateinit var vehicle: Vehicle

    init{
        itemView.setOnClickListener { VehicleConsumer?.accept(vehicle)}
    }
}