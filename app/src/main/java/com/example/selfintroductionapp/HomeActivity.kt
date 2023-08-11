package com.example.selfintroductionapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val home_name = findViewById<TextView>(R.id.home_id)

        val home_endButton = findViewById<ConstraintLayout>(R.id.home_endButton)

        val home_image = findViewById<ImageView>(R.id.home_image)


        if(intent.hasExtra("id")) {
            home_name.text = "아이디 : ${intent.getStringExtra("id")}"
        }

        home_endButton.setOnClickListener {
            finish()
        }

        val randomImage_id = when ((1..5).random()) {
            1 -> R.drawable.baseline_beach_access_24
            2 -> R.drawable.baseline_emoji_emotions_24
            3 -> R.drawable.baseline_bedtime_24
            4 -> R.drawable.baseline_bedroom_baby_24
            5 -> R.drawable.baseline_beach_access_24
            else -> R.drawable.baseline_beach_access_24
        }

        home_image.setImageDrawable(ResourcesCompat.getDrawable(resources, randomImage_id, null))









    }
}