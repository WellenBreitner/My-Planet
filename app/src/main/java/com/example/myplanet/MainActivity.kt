package com.example.myplanet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mFragment = GetStartedFragment()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_Container, mFragment, GetStartedFragment::class.java.simpleName)
            commit()
        }
    }
}