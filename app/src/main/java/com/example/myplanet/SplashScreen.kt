package com.example.myplanet

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val splashscreen = findViewById<ImageView>(R.id.splashScreen)
        val textSplashScreen = findViewById<TextView>(R.id.textSplashScreen)

        splashscreen.alpha = 0f
        textSplashScreen.alpha = 0f

        splashscreen.animate().setDuration(5000).alpha(1f).withEndAction {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(com.airbnb.lottie.R.anim.abc_fade_in, com.airbnb.lottie.R.anim.abc_fade_out)
            finish()
        }

        textSplashScreen.animate().setDuration(5000).alpha(1f)
    }
}