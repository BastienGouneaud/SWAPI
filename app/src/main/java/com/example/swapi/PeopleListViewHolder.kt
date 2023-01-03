package com.example.swapi

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PeopleListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    var txtName : TextView = itemView.findViewById(R.id.txtName)
    var txtGender : TextView = itemView.findViewById(R.id.txtGender)
    var txtBirthYear : TextView = itemView.findViewById(R.id.txtBirthYear)
}