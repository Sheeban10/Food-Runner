package com.example.foodruner.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.RelativeLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodruner.R
import com.example.foodruner.adapter.HomeRecyclerAdapter
import com.example.foodruner.model.Restaurants

class HomeFragment : Fragment() {

    lateinit var recyclerHome : RecyclerView
    lateinit var layoutManager : RecyclerView.LayoutManager

    lateinit var recyclerAdapter : HomeRecyclerAdapter
    lateinit var progressLayout : RelativeLayout
    lateinit var progressBar : ProgressBar

    var restaurantsList = arrayListOf<Restaurants>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)


        progressLayout = view.findViewById(R.id.rlHome)
        progressBar = view.findViewById(R.id.progressBar)

        progressLayout.visibility = View.VISIBLE

        recyclerHome = view.findViewById(R.id.recyclerHome)

        layoutManager = LinearLayoutManager(activity)


    }



}