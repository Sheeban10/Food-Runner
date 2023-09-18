package com.example.foodruner.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodruner.R
import com.example.foodruner.model.Restaurants
import com.squareup.picasso.Picasso

class HomeRecyclerAdapter(val context : Context, val itemList : ArrayList<Restaurants>) : RecyclerView.Adapter<HomeRecyclerAdapter.HomeViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.restaurants_recycler_view, parent, false)
            return HomeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {

        val restaurants = itemList[position]

        holder.tvRestName.text = restaurants.restName
        holder.tvCost.text = restaurants.restCost
        holder.tvRating.text = restaurants.restRating
        Picasso.get().load(restaurants.restImage).error(R.drawable.rest_image_def).into(holder.imgRest)
    }


    class HomeViewHolder(view: View): RecyclerView.ViewHolder(view){

        val tvRestName : TextView = view.findViewById(R.id.tvNameRestaurant)
        val tvCost : TextView = view.findViewById(R.id.tvCost)
        val tvRating : TextView = view.findViewById(R.id.tvRating)
        val imgRest : ImageView = view.findViewById(R.id.imgRestaurant)
        val btnFav : Button = view.findViewById(R.id.btnFavourites)

    }
}