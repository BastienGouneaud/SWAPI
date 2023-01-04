package com.example.swapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnGoToPerson = findViewById<Button>(R.id.btnListPerson);
        btnGoToPerson.setOnClickListener{
            val intent_person = Intent(this, ListPeople::class.java)
            startActivity(intent_person)
        }

        val btnGoToPlanet = findViewById<Button>(R.id.btnListPlanet);
        btnGoToPlanet.setOnClickListener{
            val intent_planet = Intent(this, ListPlanet::class.java)
            startActivity(intent_planet)
        }

        val btnGoToVehicles = findViewById<Button>(R.id.btnListVehicles);
        btnGoToVehicles.setOnClickListener{
            val intent_vehicles = Intent(this, ListVehicles::class.java)
            startActivity(intent_vehicles)
        }
    }
}