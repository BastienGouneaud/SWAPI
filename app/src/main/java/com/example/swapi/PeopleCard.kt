package com.example.swapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
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

class PeopleCard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_card)

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