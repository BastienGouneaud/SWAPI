package com.example.swapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.math.cos

const val PARAM_VEHICLE_NAME : String = "name_vehicle"
const val PARAM_VEHICLE_MODEL : String = "model_vehicle"
const val PARAM_VEHICLE_MANUFACTURER : String = "manufacturer_vehicle"
const val PARAM_VEHICLE_COST : String = "cost_vehicle"
const val PARAM_VEHICLE_LENGTH : String = "length_vehicle"
const val PARAM_VEHICLE_SPEED : String = "speed_vehicle"
const val PARAM_VEHICLE_CREW : String = "crew_vehicle"
const val PARAM_VEHICLE_PASSENGERS : String = "passengers_vehicle"
const val PARAM_VEHICLE_CAPACITY : String = "capacity_vehicle"
const val PARAM_VEHICLE_CONSUMABLE : String = "consumable_vehicle"
const val PARAM_VEHICLE_CLASS : String = "class_vehicle"
const val PARAM_VEHICLE_CREATED : String = "created_vehicle"
const val PARAM_VEHICLE_EDITED : String = "edited_vehicle"


class VehicleCard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicle_card)

        val vehicles_name = intent?.getStringExtra(PARAM_VEHICLE_NAME)
        val name = findViewById<TextView>(R.id.ResVehicleName)
        name.setText(vehicles_name)

        val vehicles_model = intent?.getStringExtra(PARAM_VEHICLE_MODEL)
        val model = findViewById<TextView>(R.id.ResVehicleModel)
        model.setText(vehicles_model)

        val vehicles_manufacturer = intent?.getStringExtra(PARAM_VEHICLE_MANUFACTURER)
        val manufacturer = findViewById<TextView>(R.id.ResVehicleManufacturer)
        manufacturer.setText(vehicles_manufacturer)

        val vehicles_cost = intent?.getStringExtra(PARAM_VEHICLE_COST)
        val cost = findViewById<TextView>(R.id.ResVehicleCost)
        cost.setText(vehicles_cost)

        val vehicles_length = intent?.getStringExtra(PARAM_VEHICLE_LENGTH)
        val length = findViewById<TextView>(R.id.ResVehicleLength)
        length.setText(vehicles_length)

        val vehicles_speed = intent?.getStringExtra(PARAM_VEHICLE_SPEED)
        val speed = findViewById<TextView>(R.id.ResVehicleSpeed)
        speed.setText(vehicles_speed)

        val vehicles_crew= intent?.getStringExtra(PARAM_VEHICLE_CREW)
        val crew = findViewById<TextView>(R.id.ResVehicleCrew)
        crew.setText(vehicles_crew)

        val vehicles_passengers= intent?.getStringExtra(PARAM_VEHICLE_PASSENGERS)
        val passengers = findViewById<TextView>(R.id.ResVehiclePassengers)
        passengers.setText(vehicles_passengers)

        val vehicles_capacity= intent?.getStringExtra(PARAM_VEHICLE_CAPACITY)
        val capacity = findViewById<TextView>(R.id.ResVehicleCapacity)
        capacity.setText(vehicles_capacity)

        val vehicles_consumable= intent?.getStringExtra(PARAM_VEHICLE_CONSUMABLE)
        val consumable = findViewById<TextView>(R.id.ResVehicleConsumable)
        consumable.setText(vehicles_consumable)

        val vehicles_class= intent?.getStringExtra(PARAM_VEHICLE_CLASS)
        val clas = findViewById<TextView>(R.id.ResVehicleClass)
        clas.setText(vehicles_class)

        val vehicles_created= intent?.getStringExtra(PARAM_VEHICLE_CREATED)
        val created = findViewById<TextView>(R.id.ResVehicleCreated)
        created.setText(vehicles_created)

        val vehicles_edited= intent?.getStringExtra(PARAM_VEHICLE_EDITED)
        val edited = findViewById<TextView>(R.id.ResVehicleEdited)
        edited.setText(vehicles_edited)

        findViewById<Button>(R.id.VehicleBackbutton).setOnClickListener{
            finish()
        }
    }
}