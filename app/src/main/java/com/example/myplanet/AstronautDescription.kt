package com.example.myplanet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class AstronautDescription : AppCompatActivity() {

    companion object {
        const val NAME_ASTRONAUT = "NAME_ASTRONAUT"
        const val IMAGE_ASTRONAUT = "IMAGE_ASTRONAUT"
//        const val DESC_ASTRONAUT = "DESC_ASTRONAUT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_astronaut_description)

        val imageAstronaut: ImageView = findViewById(R.id.astronautImage)
        val nameAstronaut: TextView = findViewById(R.id.astronautName)

        val getImage = intent.getIntExtra(IMAGE_ASTRONAUT, 0)
        val getName = intent.getStringExtra(NAME_ASTRONAUT)

        imageAstronaut.setImageResource(getImage)
        nameAstronaut.text = getName
    }
}