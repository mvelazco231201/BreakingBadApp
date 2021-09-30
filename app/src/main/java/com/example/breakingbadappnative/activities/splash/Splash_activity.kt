package com.example.breakingbadapp.activities.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.example.breakingbadapp.R
import com.example.breakingbadapp.activities.main.MainActivity

class Splash_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val backgrounding : ImageView = findViewById(R.id.splash)
        val sideAnimation = AnimationUtils.loadAnimation(this, R.anim.slide)
        backgrounding.startAnimation(sideAnimation)

        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        },6000)
    }
}
