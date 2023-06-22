package com.example.travelapp.Dashboard.Profile

import android.content.Intent.getIntent
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.travelapp.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.squareup.picasso.Picasso

class ProfileFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.profile_fragment, container, false)

//        val user = FirebaseAuth.getInstance().currentUser
//        val providerId = user?.providerData?.get(0)?.providerId
//
//        val profilePicture = view.findViewById<ImageView>(R.id.profile_picture)
//        val emailAddress = view.findViewById<TextView>(R.id.email_address)
//
//        if (providerId == GoogleAuthProvider.PROVIDER_ID) {
//            val account = GoogleSignIn.getLastSignedInAccount(requireContext())
//            val profilePhotoUrl = account?.photoUrl
//
//            Picasso.get().load(profilePhotoUrl).into(profilePicture)
//            profilePicture.setBackgroundColor(Color.WHITE)
//
//            emailAddress.text = GoogleSignIn.getLastSignedInAccount(view.context)?.email
//
//        } else if (providerId == EmailAuthProvider.PROVIDER_ID) {
//            emailAddress.text = FirebaseAuth.getInstance().currentUser?.email
//        }

        return view
    }
}