package com.example.travelapp.Dashboard.Home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.travelapp.Adapter
import com.example.travelapp.PlaceData
import com.example.travelapp.R
import com.example.travelapp.SetData
import com.google.firebase.database.*

class HomeFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.home_fragment, container, false)

        val app_recycler = view.findViewById<RecyclerView>(R.id.app_recycler)

        val database: DatabaseReference = FirebaseDatabase.getInstance().reference
        val placesRef = database.child("places")

        val listener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val placesList = mutableListOf<PlaceData>()

                for (placeSnapshot in snapshot.children) {
                    val id = placeSnapshot.child("id").getValue(Int::class.java)
                    val title = placeSnapshot.child("title").getValue(String::class.java)
                    val description = placeSnapshot.child("description").getValue(String::class.java)
                    val overview = placeSnapshot.child("overview").getValue(String::class.java)
                    val location = placeSnapshot.child("location").getValue(String::class.java)
                    val rating = placeSnapshot.child("rating").getValue(String::class.java)

                    val placeData = PlaceData(id, title, description, overview, location, rating)
                    placesList.add(placeData)
                }

                app_recycler.adapter = Adapter(placesList)
                app_recycler.layoutManager = LinearLayoutManager(view.context)
            }

            override fun onCancelled(error: DatabaseError) {

            }
        }

        placesRef.addListenerForSingleValueEvent(listener)

        val searchView = view.findViewById<SearchView>(R.id.search_box)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                val listener = object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        val placesList = mutableListOf<PlaceData>()

                        for (placeSnapshot in snapshot.children) {
                            val id = placeSnapshot.child("id").getValue(Int::class.java)
                            val title = placeSnapshot.child("title").getValue(String::class.java)
                            val description = placeSnapshot.child("description").getValue(String::class.java)
                            val overview = placeSnapshot.child("overview").getValue(String::class.java)
                            val location = placeSnapshot.child("location").getValue(String::class.java)
                            val rating = placeSnapshot.child("rating").getValue(String::class.java)

                            val placeData = PlaceData(id, title, description, overview, location, rating)
                            placesList.add(placeData)
                        }

                        val filteredPlaces = placesList.filter { place ->
                            if (newText != null) {
                                place.title?.lowercase()?.contains(newText.lowercase()) == true ||
                                        place.description?.lowercase()
                                            ?.contains(newText.lowercase()) == true ||
                                        place.location?.lowercase()?.contains(newText.lowercase()) == true
                            } else {
                                false
                            }
                        }

                        app_recycler.adapter = Adapter(filteredPlaces)
                        app_recycler.layoutManager = LinearLayoutManager(view.context)
                    }

                    override fun onCancelled(error: DatabaseError) {

                    }
                }
                placesRef.addListenerForSingleValueEvent(listener)

                return true
            }
        })

        return view
    }
}