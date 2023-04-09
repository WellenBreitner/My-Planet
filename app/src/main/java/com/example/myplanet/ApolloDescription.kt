package com.example.myplanet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ApolloDescription : AppCompatActivity() {

    companion object {
        const val NAME_APOLLO = "NAME_APOLLO"
        const val IMAGE_APOLLO = "IMAGE_APOLLO"
        const val DESC_APOLLO = "DESC_APOLLO"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apollo_desciption)

        val imageAstronaut: ImageView = findViewById(R.id.apolloImage)
        val nameAstronaut: TextView = findViewById(R.id.apolloName)
        val descAstronaut: TextView = findViewById(R.id.apolloDescription)

        val getImage = intent.getIntExtra(IMAGE_APOLLO, 0)
        val getName = intent.getStringExtra(NAME_APOLLO)
        val getDesc = intent.getStringExtra(DESC_APOLLO)

        imageAstronaut.setImageResource(getImage)
        nameAstronaut.text = getName
        descAstronaut.text = getDesc
    }
}