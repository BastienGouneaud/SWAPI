package com.example.swapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Integer.parseInt
import java.text.SimpleDateFormat
import java.util.*

const val PARAM_PEOPLE_NAME : String = "name_people"
const val PARAM_PEOPLE_HEIGHT : String = "height_people"
const val PARAM_PEOPLE_MASS : String = "mass_people"
const val PARAM_PEOPLE_HAIR : String = "hair_people"
const val PARAM_PEOPLE_BIRTH : String = "birth_people"
const val PARAM_PEOPLE_GENDER : String = "gender_people"
const val PARAM_PEOPLE_CREATED : String = "created_people"
const val PARAM_PEOPLE_EDITED : String = "edited_people"
const val PARAM_PEOPLE_WORLD : String = "planet_people"

class PeopleCard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_card)

        val planet_name = intent?.getStringExtra(PARAM_PEOPLE_WORLD)

        val people_name = intent?.getStringExtra(PARAM_PEOPLE_NAME)
        val name = findViewById<TextView>(R.id.ResName)
        name.setText(people_name)

        val people_height = intent?.getStringExtra(PARAM_PEOPLE_HEIGHT)
        val height = findViewById<TextView>(R.id.ResHeight)
        height.setText(people_height)

        val people_mass = intent?.getStringExtra(PARAM_PEOPLE_MASS)
        val mass = findViewById<TextView>(R.id.ResMass)
        mass.setText(people_mass)

        val people_hair = intent?.getStringExtra(PARAM_PEOPLE_HAIR)
        val hair = findViewById<TextView>(R.id.ResHair)
        hair.setText(people_hair)

        val people_birth = intent?.getStringExtra(PARAM_PEOPLE_BIRTH)
        val birth = findViewById<TextView>(R.id.ResBirth)
        birth.setText(people_birth)

        val people_gender = intent?.getStringExtra(PARAM_PEOPLE_GENDER)
        val gender = findViewById<TextView>(R.id.ResGender)
        gender.setText(people_gender)

        val people_created = intent?.getStringExtra(PARAM_PEOPLE_CREATED)
        val created = findViewById<TextView>(R.id.ResCreated)
        created.setText(dateGeneration(people_created))

        val people_edited = intent?.getStringExtra(PARAM_PEOPLE_EDITED)
        val edited = findViewById<TextView>(R.id.ResEdited)
        edited.setText(dateGeneration(people_edited))

        findViewById<Button>(R.id.PersonBackbutton).setOnClickListener{
            finish()
        }

        findViewById<Button>(R.id.buttonGoToPlanet).setOnClickListener{
            val intent_planetCard = Intent(this, PlanetCard::class.java)
            val id_url = parseInt(planet_name?.split("/")?.get(5))

            //TEST
            val retrofit = Retrofit.Builder()
                .baseUrl("https://swapi.dev/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val swapi = retrofit.create(SwapiService::class.java)

            swapi.planet(id_url).enqueue(object : Callback<Planet>  {
                override fun onResponse(call: Call<Planet>, response: Response<Planet>) {
                    if (response.isSuccessful) {
                        Log.d("DEBUG", "received planet named ${response.body()?.name}")
                        Log.d("DEBUG", "received planet surface ${response.body()?.surfaceWater}")
                        intent_planetCard.putExtra(PARAM_PLANET_NAME, response.body()?.name.toString())
                        intent_planetCard.putExtra(PARAM_PLANET_ROTATION, response.body()?.rotationPeriod.toString())
                        intent_planetCard.putExtra(PARAM_PLANET_ORBITAL, response.body()?.orbitalPeriod.toString())
                        intent_planetCard.putExtra(PARAM_PLANET_DIAMETER, response.body()?.diameter.toString())
                        intent_planetCard.putExtra(PARAM_PLANET_CLIMATE, response.body()?.climate.toString())
                        intent_planetCard.putExtra(PARAM_PLANET_GRAVITY, response.body()?.gravity.toString())
                        intent_planetCard.putExtra(PARAM_PLANET_TERRAIN, response.body()?.terrain.toString())
                        intent_planetCard.putExtra(PARAM_PLANET_SURFACE, response.body()?.surfaceWater.toString())
                        intent_planetCard.putExtra(PARAM_PLANET_POPULATION, response.body()?.population.toString())
                        intent_planetCard.putExtra(PARAM_PLANET_CREATED, response.body()?.created.toString())
                        intent_planetCard.putExtra(PARAM_PLANET_EDITED, response.body()?.edited.toString())
                        startActivity(intent_planetCard)
                    } else {
                        Log.d("DEBUG", "received unsuccessful response : ${response.code()} ${response.message()}")
                    }
                }

                override fun onFailure(call: Call<Planet>, t: Throwable) {
                    Log.d("DEBUG", "error while retrieving people : ${t.localizedMessage}")
                }
            })
            //FIN TEST
        }
    }

    private fun dateGeneration(dateTime: String?): String {
        val str = dateTime?.split("T")
        // date -> (YYYY-MM-JJ)
        val date = str?.get(0)
        val tab_date = date?.split("-")
        // hour -> (MM:HH:SS)
        val hour = (str?.get(1)?.split((".")))?.get(0)
        // Date with format JJ/MM/YYYY HH:MM:SS
        var outputDate = tab_date?.get(2)+"/"+tab_date?.get(1)+"/"+tab_date?.get(0)+" "+hour
        return outputDate
    }
}