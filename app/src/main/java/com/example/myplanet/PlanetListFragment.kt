package com.example.myplanet

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import me.relex.circleindicator.CircleIndicator2

class PlanetListFragment : Fragment() {

    private val listData = ArrayList<Dataplanet>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var listView : ImageButton
    private lateinit var gridHorizontal : ImageButton
    private lateinit var gridVertical : ImageButton

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

        listView = requireActivity().findViewById(R.id.listView)
        gridHorizontal = requireActivity().findViewById(R.id.gridHorizontal)
        gridVertical = requireActivity().findViewById(R.id.gridVertical)

        listData.addAll(getDataPlanet())
        showGridHorizontalView()
        circleIndicator()

        gridHorizontal.setOnClickListener {
            showGridHorizontalView()
        }

        listView.setOnClickListener {
            showListView()
        }

        gridVertical.setOnClickListener {
            showGridVerticalView()
        }
    }

    private fun showGridHorizontalView() {
        recyclerView.layoutManager = GridLayoutManager(requireContext(),1,RecyclerView.HORIZONTAL,false)
        val adapter = GridHorizontalAdapter(listData)
        recyclerView.adapter = adapter

    }

    private fun showListView() {
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = ListAdapter(listData)
        recyclerView.adapter = adapter

    }

    private fun showGridVerticalView() {
        recyclerView.layoutManager = GridLayoutManager(requireContext(),2,RecyclerView.VERTICAL,false)
        val adapter = GridVerticalAdapter(listData)
        recyclerView.adapter = adapter
    }

    private fun circleIndicator(){
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