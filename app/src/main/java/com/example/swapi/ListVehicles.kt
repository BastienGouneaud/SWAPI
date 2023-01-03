package com.example.swapi

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

        val adapter = VehiclesListAdapter()
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
                Log.d("DEBUG", "error while retrieving people : ${t.localizedMessage}")
            }
        })

    }
}