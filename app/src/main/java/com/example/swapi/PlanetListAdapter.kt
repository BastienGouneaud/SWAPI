package com.example.swapi

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PlanetListAdapter : RecyclerView.Adapter<PlanetListViewHolder>(){
    var _planetList: List<Planet> = ArrayList<Planet>()
    var planetList: List<Planet>
        get() = _planetList
        @SuppressLint("Notifications de chargement de données")
        set (value){
            _planetList = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetListViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.planet_item,parent,false)
        return PlanetListViewHolder(v)
    }

    override fun onBindViewHolder(holder: PlanetListViewHolder, position: Int) {
        val planet = planetList[position]
        holder.txtName.text = planet.name
        holder.txtClimate.text = planet.climate
        holder.txtDiamater.text = planet.diameter
    }

    override fun getItemCount(): Int {
        return planetList.size
    }
}