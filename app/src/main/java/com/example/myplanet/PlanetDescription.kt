package com.example.myplanet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class PlanetDescription : AppCompatActivity() {
    companion object {
        const val IMAGE_PLANET = "IMAGE_PLANET"
        const val NAME_PlANET = "NAME_PLANET"
        const val DESC_PLANET = "DESC_PLANET"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planet_description)

        val imagePlanet = findViewById<ImageView>(R.id.descImagePlanet)
        val namePlanet = findViewById<TextView>(R.id.descNamePlanet)
        val descPlanet = findViewById<TextView>(R.id.descDescPlanet)
        val rocket = findViewById<ImageView>(R.id.rocketImage)

        val getImage = intent.getIntExtra(IMAGE_PLANET, 0)
        val getName = intent.getStringExtra(NAME_PlANET)
        val getDesc = intent.getStringExtra(DESC_PLANET)

        imagePlanet.setImageResource(getImage)
        namePlanet.text = getName
        descPlanet.text = getDesc

        rocket.setOnClickListener {
            val intent = Intent(this@PlanetDescription,ApolloRecyclerView::class.java)
            startActivity(intent)
        }
    }
}