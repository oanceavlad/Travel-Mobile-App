package com.example.travelapp

import android.net.Uri
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView

import androidx.appcompat.app.AppCompatActivity

class PlaceDetails : AppCompatActivity() {
    private lateinit var obj:PlaceData
    private var placeImg:Int?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.activity_place_details)

        obj = intent.getParcelableExtra("place")!!
        placeImg = intent.getIntExtra("placeImage",-1)
        setData(obj, placeImg!!)

        val presentationVideo = findViewById<VideoView>(R.id.presentation_video)
        when (obj.title) {
            "South Beach"->{
                val videoPath = "android.resource://" + getPackageName() + "/" + R.raw.south_beach
                presentationVideo.setVideoURI(Uri.parse(videoPath))
            }
            "Swiss Alps"->{
                val videoPath = "android.resource://" + getPackageName() + "/" + R.raw.swiss_alps
                presentationVideo.setVideoURI(Uri.parse(videoPath))
            }
            "Whistler Blackcomb"->{
                val videoPath = "android.resource://" + getPackageName() + "/" + R.raw.wh_blackcomb
                presentationVideo.setVideoURI(Uri.parse(videoPath))
            }
            "Pompano Beach"->{
                val videoPath = "android.resource://" + getPackageName() + "/" + R.raw.pompano_beach
                presentationVideo.setVideoURI(Uri.parse(videoPath))
            }
            "Thai Square Spa"->{
                val videoPath = "android.resource://" + getPackageName() + "/" + R.raw.thai_spa
                presentationVideo.setVideoURI(Uri.parse(videoPath))
            }
            "Waterfall Safari"->{
                val videoPath = "android.resource://" + getPackageName() + "/" + R.raw.waterfall
                presentationVideo.setVideoURI(Uri.parse(videoPath))
            }
            "Louvre Museum"->{
                val videoPath = "android.resource://" + getPackageName() + "/" + R.raw.louvre_museum
                presentationVideo.setVideoURI(Uri.parse(videoPath))
            }
            "Maggie Daley Park"->{
                val videoPath = "android.resource://" + getPackageName() + "/" + R.raw.daley_park
                presentationVideo.setVideoURI(Uri.parse(videoPath))
            }
        }



        val mediacontroller=MediaController(this)

        presentationVideo.setMediaController(mediacontroller)
        mediacontroller.setAnchorView(presentationVideo)

    }

    private fun setData(obj:PlaceData, placeImage:Int) {
        val title_info = findViewById<TextView>(R.id.title_info)
        val overview_info = findViewById<TextView>(R.id.overview_info)
        val primaryImage = findViewById<ImageView>(R.id.primary_img)
        val secondary_img = findViewById<ImageView>(R.id.secondary_img)


        title_info.text = obj.title
        overview_info.text = obj.overview
        secondary_img.setImageResource(placeImage)

        when (title_info.text) {
            "South Beach"->{
                primaryImage.setImageResource(R.drawable.south_beach)


            }
            "Swiss Alps"->{
                primaryImage.setImageResource(R.drawable.swiss_alps)
            }
            "Whistler Blackcomb"->{
                primaryImage.setImageResource(R.drawable.whistler_blackcomb)
            }
            "Pompano Beach"->{
                primaryImage.setImageResource(R.drawable.pompano_beach_club)
            }
            "Thai Square Spa"->{
                primaryImage.setImageResource(R.drawable.thai_square_spa)
            }
            "Waterfall Safari"->{
                primaryImage.setImageResource(R.drawable.waterfall_safari)
            }
            "Louvre Museum"->{
                primaryImage.setImageResource(R.drawable.louvre_museum)
            }
            "Maggie Daley Park"->{
                primaryImage.setImageResource(R.drawable.maggie_daley_park)
            }
        }
    }
}