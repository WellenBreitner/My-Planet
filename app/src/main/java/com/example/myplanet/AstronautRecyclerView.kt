package com.example.myplanet

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AstronautRecyclerView : AppCompatActivity() {
    private lateinit var recyclerview: RecyclerView
    private var listData2 = ArrayList<DataAstronaut>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_astronaut_recycler_view)

        recyclerview = findViewById(R.id.astronautRecyclerView)
        recyclerview.setHasFixedSize(true)

        listData2.addAll(getDataAstronaut())
        showListAstronaut()
    }

    private fun showListAstronaut() {
        recyclerview.layoutManager = LinearLayoutManager(this)
        val adapter = AstronautListAdapter(listData2)
        recyclerview.adapter = adapter
    }

    @SuppressLint("Recycle")
    private fun getDataAstronaut(): ArrayList<DataAstronaut> {
        val getPhotoAstronaut = resources.obtainTypedArray(R.array.Data_Photo_Astronaut)
        val getNameAstronaut = resources.getStringArray(R.array.Data_Name_Astronaut)
        val getDescriptionAstronaut = resources.getStringArray(R.array.Data_Desc_Astronaut)

        val listAstronaut = ArrayList<DataAstronaut>()
        for (i in getNameAstronaut.indices) {
            val astronaut =
                DataAstronaut(
                    getPhotoAstronaut.getResourceId(i, -1),
                    getNameAstronaut[i],
                    getDescriptionAstronaut[i]
                )
            listAstronaut.add(astronaut)
        }
        return listAstronaut
    }
}