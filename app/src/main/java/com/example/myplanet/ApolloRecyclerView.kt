package com.example.myplanet

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ApolloRecyclerView : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private val listData = ArrayList<DataApollo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apollo_recycler_view)

        recyclerView = findViewById(R.id.apolloRecyclerView)
        recyclerView.setHasFixedSize(true)

        listData.addAll(getDataApollo())
        showApolloList()
    }

    private fun showApolloList() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = ApolloListAdapter(listData)
        recyclerView.adapter = adapter
    }

    @SuppressLint("Recycle")
    private fun getDataApollo(): ArrayList<DataApollo> {
        val getPhoto = resources.obtainTypedArray(R.array.Data_Photo_Apollo)
        val getName = resources.getStringArray(R.array.Data_Name_Apollo)
        val getDesc = resources.getStringArray(R.array.Data_Desc_Apollo)

        val list = ArrayList<DataApollo>()
        for (i in getName.indices){
            val apollo = DataApollo(getName[i],getPhoto.getResourceId(i,-1),getDesc[i])
            list.add(apollo)
        }
        return list
    }
}