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

class ListPlanet : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_planet)

        val lstPlanet = findViewById<RecyclerView>(R.id.lstPlanet)
        lstPlanet.layoutManager = LinearLayoutManager(this)

        val adapter = PlanetListAdapter{
            val intent_planetCard = Intent(this, PlanetCard::class.java)
            intent_planetCard.putExtra(PARAM_PLANET_NAME, it.name)
            intent_planetCard.putExtra(PARAM_PLANET_ROTATION, it.rotationPeriod)
            intent_planetCard.putExtra(PARAM_PLANET_ORBITAL, it.orbitalPeriod)
            intent_planetCard.putExtra(PARAM_PLANET_DIAMETER, it.diameter)
            intent_planetCard.putExtra(PARAM_PLANET_CLIMATE, it.climate)
            intent_planetCard.putExtra(PARAM_PLANET_GRAVITY, it.gravity)
            intent_planetCard.putExtra(PARAM_PLANET_TERRAIN, it.terrain)
            intent_planetCard.putExtra(PARAM_PLANET_SURFACE, it.surfaceWater)
            intent_planetCard.putExtra(PARAM_PLANET_POPULATION, it.population)
            intent_planetCard.putExtra(PARAM_PLANET_CREATED, it.created)
            intent_planetCard.putExtra(PARAM_PLANET_EDITED, it.edited)
            startActivity(intent_planetCard)
            Log.i("DEBUG", "touched ${it.name}")
        }

        lstPlanet.adapter = adapter

        val retrofit = Retrofit.Builder()
            .baseUrl("https://swapi.dev/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val swapi = retrofit.create(SwapiService::class.java)


        swapi.listPLanet().enqueue(object: Callback<SWModelList<Planet>> {
            override fun onResponse(
                call: Call<SWModelList<Planet>>,
                response: Response<SWModelList<Planet>>
            ) {
                if (response.isSuccessful) {
                    adapter.planetList = response.body()?.results!!
                } else {
                    Log.d("DEBUG", "received unsuccessful response : ${response.code()} ${response.message()}")
                }
            }

            override fun onFailure(call: Call<SWModelList<Planet>>, t: Throwable) {
                Log.d("DEBUG", "error while retrieving planet : ${t.localizedMessage}")
            }
        })

    }
}