package com.example.swapi

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PeopleListAdapter : RecyclerView.Adapter<PeopleListViewHolder>(){
    var _peopleList: List<People> = ArrayList<People>()
    var peopleList: List<People>
    get() = _peopleList
    @SuppressLint("Notifications de chargement de données")
    set (value){
        _peopleList = value
        notifyDataSetChanged()
    }


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