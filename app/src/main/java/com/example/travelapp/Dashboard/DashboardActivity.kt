package com.example.travelapp.Dashboard

import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.Fragment
import com.example.travelapp.Dashboard.Home.HomeFragment
import com.example.travelapp.Dashboard.Profile.ProfileFragment
import com.example.travelapp.LoginSignupActivity
import com.example.travelapp.R
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth

class DashboardActivity : AppCompatActivity() {
    private lateinit var motionLayout: MotionLayout
    private lateinit var fragmentContainer: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.dashboard_activity)

        val menuButton = findViewById<ImageView>(R.id.menu_button)
        val firebaseAuth = FirebaseAuth.getInstance()
        val navigationView = findViewById<NavigationView>(R.id.menu)

        motionLayout = findViewById(R.id.motion_layout)
        fragmentContainer = findViewById(R.id.fragment_container)

        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeFragment()).commit()

        // Actions
        menuButton.setOnClickListener {
            menuButton.setImageResource(R.drawable.arrow_back)
        }

        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> replaceFragment(HomeFragment())
                R.id.favorites -> replaceFragment(ProfileFragment())
                R.id.logout -> logoutUser(firebaseAuth)
            }

            motionLayout.transitionToStart()
            fragmentContainer.bringToFront()
            true
        }
    }

    private fun logoutUser(firebaseAuth: FirebaseAuth) {
        firebaseAuth.signOut()

        val intent = Intent(this@DashboardActivity, LoginSignupActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()

    }
}
