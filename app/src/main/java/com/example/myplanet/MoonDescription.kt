package com.example.myplanet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MoonDescription : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_moon_description)

        val rocket = findViewById<ImageView>(R.id.rocketMoon)
        rocket.setOnClickListener {
            val intent = Intent(this, ApolloRecyclerView::class.java)
            startActivity(intent)
        }
    }
}