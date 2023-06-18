package com.example.travelapp

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.activity_main)

        // Splash screen animation
        val logo1 = findViewById<ImageView>(R.id.logo1)
        val logo2 = findViewById<ImageView>(R.id.logo2)

        val animation1 = ObjectAnimator.ofFloat(logo2, "translationX", -500f, 0f)
        animation1.duration = 2500

        animation1.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator?) {
                val animation2 = ObjectAnimator.ofFloat(logo1, "alpha", 0f, 1f)
                animation2.duration = 500

                animation2.addListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator?) {
                        // Redirect to login page
                        val intent = Intent(this@MainActivity, LoginActivity::class.java)
                        startActivity(intent)
                    }
                })

                animation2.start();
            }
        })

        animation1.start()
    }
}