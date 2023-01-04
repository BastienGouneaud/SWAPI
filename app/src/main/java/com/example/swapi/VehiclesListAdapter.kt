package com.example.swapi

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.function.Consumer

class VehiclesListAdapter(private val VehicleConsumer : Consumer<Vehicle>) : RecyclerView.Adapter<VehiclesListViewHolder>(){
    var _vehiclesList: List<Vehicle> = ArrayList<Vehicle>()
    var vehiclesList: List<Vehicle>
        get() = _vehiclesList
        @SuppressLint("Notifications de chargement de données")
        set (value){
            _vehiclesList = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehiclesListViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.vehicle_item,parent,false)
        return VehiclesListViewHolder(v, VehicleConsumer)
    }

    override fun onBindViewHolder(holder: VehiclesListViewHolder, position: Int) {
        val vehicle = vehiclesList[position]
        holder.vehicle = vehicle
        holder.txtName.text = vehicle.name
    }

    override fun getItemCount(): Int {
        return vehiclesList.size
    }
}