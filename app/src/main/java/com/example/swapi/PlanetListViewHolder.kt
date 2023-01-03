package com.example.swapi

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PlanetListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    var txtName : TextView = itemView.findViewById(R.id.txtName)
    var txtClimate : TextView = itemView.findViewById(R.id.txtClimate)
    var txtDiamater : TextView = itemView.findViewById(R.id.txtDiamater)
}