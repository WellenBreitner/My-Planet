package com.example.myplanet

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import me.relex.circleindicator.CircleIndicator2

class PlanetListFragment : Fragment() {

    private val listData = ArrayList<Dataplanet>()
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_planet_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)

        listData.addAll(getDataPlanet())
        showGridView()
    }

    private fun showGridView() {
        recyclerView.layoutManager = GridLayoutManager(requireContext(),1, RecyclerView.HORIZONTAL,false)
        val adapter = GridAdapter(listData)
        recyclerView.adapter = adapter

        val pagerSnapHelper = PagerSnapHelper()
        pagerSnapHelper.attachToRecyclerView(recyclerView)

        val indicator = view?.findViewById<CircleIndicator2>(R.id.circle_indicator)
        indicator?.attachToRecyclerView(recyclerView,pagerSnapHelper)
    }

    @SuppressLint("Recycle")
    private fun getDataPlanet(): ArrayList<Dataplanet> {
        val getName = resources.getStringArray(R.array.Data_Name_Planet)
        val getPhoto = resources.obtainTypedArray(R.array.Data_Photo_Planet)

        val list = ArrayList<Dataplanet>()
        for (i in getName.indices){
            val planet = Dataplanet(getName[i],getPhoto.getResourceId(i,-1))
            list.add(planet)
        }
        return list
    }


}