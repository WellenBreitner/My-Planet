package com.example.myplanet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class SunDescription : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sun_description)

        val rocket = findViewById<ImageView>(R.id.rocketSun)
        rocket.setOnClickListener {
            val intent = Intent(this, ApolloRecyclerView::class.java)
            startActivity(intent)
        }
    }
}