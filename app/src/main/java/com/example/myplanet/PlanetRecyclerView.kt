package com.example.myplanet

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.google.android.material.navigation.NavigationView
import me.relex.circleindicator.CircleIndicator2
import java.util.NavigableMap

class PlanetRecyclerView : Fragment() {

    private val listData = ArrayList<DataPlanet>()
    private lateinit var ActionBarDrawerToggle: ActionBarDrawerToggle
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var recyclerView: RecyclerView
    private lateinit var listView: ImageButton
    private lateinit var gridHorizontal: ImageButton
    private lateinit var gridVertical: ImageButton
    private lateinit var astronaut: LottieAnimationView
    private lateinit var drawerLayoutImage: ImageView
    private lateinit var moonImage: ImageView
    private lateinit var sunImage: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_planet_recycler_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.planetRecyclerView)
        recyclerView.setHasFixedSize(true)

        listView = view.findViewById(R.id.listView)
        gridHorizontal = view.findViewById(R.id.gridHorizontal)
        gridVertical = view.findViewById(R.id.gridVertical)
        astronaut = view.findViewById(R.id.astronaut)
        drawerLayoutImage = view.findViewById(R.id.drawerLayoutImage)

        drawerLayout = view.findViewById(R.id.drawerLayout)
        navigationView = view.findViewById(R.id.navigationView)

        navigationView.itemIconTintList = null
        navigationView.setItemIconSize(60)

        moonImage = view.findViewById(R.id.moon)

        sunImage = view.findViewById(R.id.sun)

        sunImage.setOnClickListener {
            val intent = Intent(requireContext(), SunDescription::class.java)
            startActivity(intent)
        }

        moonImage.setOnClickListener {
            val intent = Intent(requireContext(), MoonDescription::class.java)
            startActivity(intent)
        }

        drawerLayoutImage.setOnClickListener {
            ActionBarDrawerToggle =
                ActionBarDrawerToggle(
                    requireActivity(),
                    drawerLayout,
                    R.string.open,
                    R.string.close
                )
            drawerLayout.addDrawerListener(ActionBarDrawerToggle)
            drawerLayout.open()
            ActionBarDrawerToggle.syncState()
        }


        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.planetMenu -> {
                    val fragment = PlanetRecyclerView()
                    val fragmentManager = parentFragmentManager
                    fragmentManager.beginTransaction().apply {
                        add(R.id.fragment_Container, fragment)
                        addToBackStack(null)
                        commit()
                    }
                }
                R.id.astronautMenu -> {
                    val intent = Intent(requireContext(), AstronautRecyclerView::class.java)
                    startActivity(intent)
                }
                R.id.apolloMenu -> {
                    val intent = Intent(requireContext(), ApolloRecyclerView::class.java)
                    startActivity(intent)
                }
                R.id.moonMenu -> {
                    val intent = Intent(requireContext(), MoonDescription::class.java)
                    startActivity(intent)
                }
                R.id.sunMenu -> {
                    val intent = Intent(requireContext(), SunDescription::class.java)
                    startActivity(intent)
                }
                R.id.exitMenu -> {
                    drawerLayout.close()
                }
            }
            true
        }


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

        astronaut.setOnClickListener {
            showAstronotList()
        }
    }

    private fun showAstronotList() {
        val intent = Intent(requireContext(), AstronautRecyclerView::class.java)
        startActivity(intent)
    }

    private fun showGridHorizontalView() {
        recyclerView.layoutManager =
            GridLayoutManager(requireContext(), 1, RecyclerView.HORIZONTAL, false)
        val adapter = GridHorizontalAdapter(listData)
        recyclerView.adapter = adapter

    }

    private fun showListView() {
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = PlanetListAdapter(listData)
        recyclerView.adapter = adapter

    }

    private fun showGridVerticalView() {
        recyclerView.layoutManager =
            GridLayoutManager(requireContext(), 2, RecyclerView.VERTICAL, false)
        val adapter = GridVerticalAdapter(listData)
        recyclerView.adapter = adapter
    }

    private fun circleIndicator() {
        val pagerSnapHelper = PagerSnapHelper()
        pagerSnapHelper.attachToRecyclerView(recyclerView)

        val indicator = view?.findViewById<CircleIndicator2>(R.id.circle_indicator)
        indicator?.attachToRecyclerView(recyclerView, pagerSnapHelper)
    }

    @SuppressLint("Recycle")
    private fun getDataPlanet(): ArrayList<DataPlanet> {
        val getName = resources.getStringArray(R.array.Data_Name_Planet)
        val getPhoto = resources.obtainTypedArray(R.array.Data_Photo_Planet)
        val getDescription = resources.getStringArray(R.array.Data_Desc_Planet)
        val getTemperature = resources.obtainTypedArray(R.array.Data_Temperature_Planet)
        val getRotaion = resources.obtainTypedArray(R.array.Data_Rotation_Planet)
        val getDiameter = resources.obtainTypedArray(R.array.Data_Diameter_Planet)
        val getDistance = resources.obtainTypedArray(R.array.Data_Distance_Planet)


        val listPlanet = ArrayList<DataPlanet>()
        for (i in getName.indices) {
            val planet = DataPlanet(getName[i], getPhoto.getResourceId(i, -1), getDescription[i],getTemperature.getResourceId(i,-1),getRotaion.getResourceId(i,-1),getDiameter.getResourceId(i,-1),getDistance.getResourceId(i,-1))
            listPlanet.add(planet)
        }
        return listPlanet
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (ActionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}