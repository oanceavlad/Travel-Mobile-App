package com.example.travelapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class Adapter(private var places:List<PlaceData>):RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        var title: TextView = view.findViewById(R.id.title)
        var placeImage: ImageView = view.findViewById(R.id.place_image)
        var description: TextView = view.findViewById(R.id.description)
        var location: TextView = view.findViewById(R.id.location)
        var rating: TextView = view.findViewById(R.id.rating)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.view,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return places.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var auxImage: Int? = null

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, PlaceDetails::class.java)
            intent.putExtra("place", places[position])
            intent.putExtra("placeImage", auxImage)
            holder.itemView.context.startActivity(intent)
        }

        holder.title.text = places[position].title
        holder.description.text = places[position].description
        holder.location.text = places[position].location
        holder.rating.text = places[position].rating

        when (places[position].title!!) {
            "South Beach" -> {
                auxImage = R.drawable.lemon
            }
            "Swiss Alps" -> {
                auxImage = R.drawable.mountain
            }
            "Whistler Blackcomb" -> {
                auxImage = R.drawable.ski
            }
            "Pompano Beach" -> {
                auxImage = R.drawable.fishing
            }
            "Thai Square Spa" -> {
                auxImage = R.drawable.spa
            }
            "Waterfall Safari" -> {
                auxImage = R.drawable.ship
            }
            "Louvre Museum" -> {
                auxImage = R.drawable.museum
            }
            "Maggie Daley Park" -> {
                auxImage = R.drawable.skating
            }
        }

        if (auxImage != null) {
            holder.placeImage.setImageResource(auxImage)
        }
    }
}
