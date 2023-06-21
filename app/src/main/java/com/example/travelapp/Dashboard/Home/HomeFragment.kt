package com.example.travelapp.Dashboard.Home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.travelapp.Adapter
import com.example.travelapp.R
import com.example.travelapp.SetData

class HomeFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.home_fragment, container, false)

        val app_recycler = view.findViewById<RecyclerView>(R.id.app_recycler)
        app_recycler.adapter = Adapter(SetData.setPlaces())
        app_recycler.layoutManager = LinearLayoutManager(this.context)

        return view
    }
}