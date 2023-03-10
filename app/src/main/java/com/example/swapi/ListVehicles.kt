package com.example.swapi

import android.content.Intent
import android.media.Image.Plane
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListVehicles : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_vehicles)

        val lstVehicles = findViewById<RecyclerView>(R.id.lstVehicles)
        lstVehicles.layoutManager = LinearLayoutManager(this)

        val adapter = VehiclesListAdapter{
            val intent_vehiclesCard = Intent(this, VehicleCard::class.java)
            intent_vehiclesCard.putExtra(PARAM_VEHICLE_NAME, it.name)
            intent_vehiclesCard.putExtra(PARAM_VEHICLE_MODEL, it.model)
            intent_vehiclesCard.putExtra(PARAM_VEHICLE_MANUFACTURER, it.manufacturer)
            intent_vehiclesCard.putExtra(PARAM_VEHICLE_COST, it.costInCredits)
            intent_vehiclesCard.putExtra(PARAM_VEHICLE_LENGTH, it.length)
            intent_vehiclesCard.putExtra(PARAM_VEHICLE_SPEED, it.maxAtmospheringSpeed)
            intent_vehiclesCard.putExtra(PARAM_VEHICLE_CREW, it.crew)
            intent_vehiclesCard.putExtra(PARAM_VEHICLE_PASSENGERS, it.passengers)
            intent_vehiclesCard.putExtra(PARAM_VEHICLE_CAPACITY, it.cargoCapacity)
            intent_vehiclesCard.putExtra(PARAM_VEHICLE_CONSUMABLE, it.consumables)
            intent_vehiclesCard.putExtra(PARAM_VEHICLE_CLASS, it.vehicleClass)
            intent_vehiclesCard.putExtra(PARAM_VEHICLE_CREATED, it.created)
            intent_vehiclesCard.putExtra(PARAM_VEHICLE_EDITED, it.edited)
            Log.i("DEBUG", "touched ${it.name}")
            startActivity(intent_vehiclesCard)
        }
        lstVehicles.adapter = adapter

        val retrofit = Retrofit.Builder()
            .baseUrl("https://swapi.dev/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val swapi = retrofit.create(SwapiService::class.java)


        swapi.listVehicles().enqueue(object: Callback<SWModelList<Vehicle>> {
            override fun onResponse(
                call: Call<SWModelList<Vehicle>>,
                response: Response<SWModelList<Vehicle>>
            ) {
                if (response.isSuccessful) {
                    adapter.vehiclesList = response.body()?.results!!
                } else {
                    Log.d("DEBUG", "received unsuccessful response : ${response.code()} ${response.message()}")
                }
            }

            override fun onFailure(call: Call<SWModelList<Vehicle>>, t: Throwable) {
                Log.d("DEBUG", "error while retrieving vehicle : ${t.localizedMessage}")
            }
        })

    }
}