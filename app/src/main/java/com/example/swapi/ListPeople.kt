package com.example.swapi

import android.content.Intent
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

class ListPeople : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_persons)

        val lstPeople = findViewById<RecyclerView>(R.id.lstPerson)
        lstPeople.layoutManager = LinearLayoutManager(this)

        val adapter = PeopleListAdapter{
            val intent_peopleCard = Intent(this, PeopleCard::class.java)
            Log.i("DEBUG", "touched ${it.name}")
            startActivity(intent_peopleCard)
        }
        lstPeople.adapter = adapter

        val retrofit = Retrofit.Builder()
            .baseUrl("https://swapi.dev/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val swapi = retrofit.create(SwapiService::class.java)


        swapi.listPeople().enqueue(object: Callback<SWModelList<People>> {
            override fun onResponse(
                call: Call<SWModelList<People>>,
                response: Response<SWModelList<People>>
            ) {
                if (response.isSuccessful) {
                    adapter.peopleList = response.body()?.results!!
                } else {
                    Log.d("DEBUG", "received unsuccessful response : ${response.code()} ${response.message()}")
                }
            }

            override fun onFailure(call: Call<SWModelList<People>>, t: Throwable) {
                Log.d("DEBUG", "error while retrieving people : ${t.localizedMessage}")
            }
        })

    }
}