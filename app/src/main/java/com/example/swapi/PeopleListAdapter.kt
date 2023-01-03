package com.example.swapi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PeopleListAdapter : RecyclerView.Adapter<PeopleListViewHolder>(){
    lateinit var peopleList: List<People>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleListViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.person_item,parent,false)
        return PeopleListViewHolder(v)
    }

    override fun onBindViewHolder(holder: PeopleListViewHolder, position: Int) {
        val people = peopleList[position]
        holder.txtName.text = people.name
        holder.txtBirthYear.text = people.birthYear.toString()
        holder.txtGender.text = people.gender
    }

    override fun getItemCount(): Int {
        return peopleList.size
    }
}