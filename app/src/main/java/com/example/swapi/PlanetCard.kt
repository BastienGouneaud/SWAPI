package com.example.swapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

const val PARAM_PLANET_NAME : String = "name_planet"
const val PARAM_PLANET_ROTATION : String = "rotation_planet"
const val PARAM_PLANET_ORBITAL : String = "orbital_planet"
const val PARAM_PLANET_DIAMETER : String = "diameter_planet"
const val PARAM_PLANET_CLIMATE : String = "climate_planet"
const val PARAM_PLANET_GRAVITY : String = "gravity_planet"
const val PARAM_PLANET_TERRAIN : String = "terrain_planet"
const val PARAM_PLANET_SURFACE : String = "surface_planet"
const val PARAM_PLANET_POPULATION : String = "population_planet"
const val PARAM_PLANET_CREATED : String = "created_planet"
const val PARAM_PLANET_EDITED : String = "edited_planet"

class PlanetCard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planet_card)

        val planet_name = intent?.getStringExtra(PARAM_PLANET_NAME)
        val name = findViewById<TextView>(R.id.ResPlanetName)
        name.setText(planet_name)

        val planet_rotation = intent?.getStringExtra(PARAM_PLANET_ROTATION)
        val rotation = findViewById<TextView>(R.id.ResPlanetRotation)
        rotation.setText(planet_rotation)

        val planet_orbital = intent?.getStringExtra(PARAM_PLANET_ORBITAL)
        val orbital = findViewById<TextView>(R.id.ResPlanetOrbital)
        orbital.setText(planet_orbital)

        val planet_diameter = intent?.getStringExtra(PARAM_PLANET_DIAMETER)
        val diameter = findViewById<TextView>(R.id.ResPlanetDiameter)
        diameter.setText(planet_diameter)

        val planet_climate = intent?.getStringExtra(PARAM_PLANET_CLIMATE)
        val climate = findViewById<TextView>(R.id.ResPlanetClimate)
        climate.setText(planet_climate)

        val planet_gravity = intent?.getStringExtra(PARAM_PLANET_GRAVITY)
        val gravity = findViewById<TextView>(R.id.ResPlanetGravity)
        gravity.setText(planet_gravity)

        val planet_terrain = intent?.getStringExtra(PARAM_PLANET_TERRAIN)
        val terrain = findViewById<TextView>(R.id.ResPlanetTerrain)
        terrain.setText(planet_terrain)

        val planet_surface = intent?.getStringExtra(PARAM_PLANET_SURFACE)
        val surface = findViewById<TextView>(R.id.ResPlanetSurface)
        surface.setText(planet_surface)

        val planet_population = intent?.getStringExtra(PARAM_PLANET_POPULATION)
        val population = findViewById<TextView>(R.id.ResPlanetPopulation)
        population.setText(planet_population)

        val planet_created = intent?.getStringExtra(PARAM_PLANET_CREATED)
        val created = findViewById<TextView>(R.id.ResPlanetCreated)
        created.setText(dateGeneration(planet_created))

        val planet_edited = intent?.getStringExtra(PARAM_PLANET_EDITED)
        val edited = findViewById<TextView>(R.id.ResPlanetEdited)
        edited.setText(dateGeneration(planet_edited))

        findViewById<Button>(R.id.PlanetBackbutton).setOnClickListener{
            finish()
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