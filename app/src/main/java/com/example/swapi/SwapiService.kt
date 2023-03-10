package com.example.swapi

import com.example.swapi.People
import com.example.swapi.SWModelList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SwapiService {
    @GET("people/{id}/")
    fun people(@Path("id") id: Int): Call<People>

    @GET("people/")
    fun listPeople(): Call<SWModelList<People>>

    @GET("planets/")
    fun listPLanet(): Call<SWModelList<Planet>>

    @GET("planets/{id}/")
    fun planet(@Path("id") id: Int): Call<Planet>

    @GET("starships/")
    fun listVehicles(): Call<SWModelList<Vehicle>>
}