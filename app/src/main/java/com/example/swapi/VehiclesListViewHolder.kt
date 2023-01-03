package com.example.swapi

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VehiclesListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    var txtName : TextView = itemView.findViewById(R.id.txtName)
    var txtModel : TextView = itemView.findViewById(R.id.txtModel)
    var txtManufacturer : TextView = itemView.findViewById(R.id.txtManufacturer)
}