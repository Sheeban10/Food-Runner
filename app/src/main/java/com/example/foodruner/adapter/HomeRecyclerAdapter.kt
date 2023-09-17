package com.example.foodruner.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodruner.model.Restaurants

class HomeRecyclerAdapter(val context : Context, val itemList : ArrayList<Restaurants>) : RecyclerView.Adapter<HomeRecyclerAdapter.HomeViewHolder>() {

    class HomeViewHolder(view: View): RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}