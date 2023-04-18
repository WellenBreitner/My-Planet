package com.example.myplanet

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class PlanetListAdapter(private val listPlanet: ArrayList<DataPlanet>) :
    RecyclerView.Adapter<PlanetListAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.listNameOfPlanet)
        val textView2: TextView = itemView.findViewById(R.id.listDescOfPlanet)
        val imageView: ImageView = itemView.findViewById(R.id.listImageOfPlanet)
        val cardView: CardView = itemView.findViewById(R.id.listPlanetCardView)
        val temperature: ImageView = itemView.findViewById(R.id.listTemperatureImage)
        val rotation: ImageView = itemView.findViewById(R.id.listRotationImage)
        val diameter: ImageView = itemView.findViewById(R.id.listDiameterImage)
        val distance: ImageView = itemView.findViewById(R.id.listDistanceImage)
        val temperatureText: TextView = itemView.findViewById(R.id.listTemperatureText)
        val rotationText: TextView = itemView.findViewById(R.id.listRotationText)
        val diameterText: TextView = itemView.findViewById(R.id.listDiameterText)
        val distanceText: TextView = itemView.findViewById(R.id.listDistanceText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.listplanet, parent, false)
        )
    }

    override fun getItemCount() = listPlanet.size
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val bindData = listPlanet[position]
        holder.imageView.setImageResource(bindData.photoPlanet)
        holder.textView.text = bindData.namePlanet
        holder.textView2.text = bindData.descriptionPlanet
        holder.temperature.setImageResource(bindData.temperaturePlanet)
        holder.rotation.setImageResource(bindData.rotationPlanet)
        holder.diameter.setImageResource(bindData.diameterPlanet)
        holder.distance.setImageResource(bindData.distancePlanet)
        holder.temperatureText.text = bindData.temperaturePlanetText
        holder.rotationText.text = bindData.rotationPlanetText
        holder.diameterText.text = bindData.diameterPlanetText
        holder.distanceText.text = bindData.distancePlanetText


        holder.cardView.startAnimation(
            AnimationUtils.loadAnimation(
                holder.cardView.context,
                com.airbnb.lottie.R.anim.abc_slide_in_bottom
            )
        )

        holder.cardView.setOnClickListener {
            val intent = Intent(holder.itemView.context, PlanetDescription::class.java)
            intent.putExtra(PlanetDescription.NAME_PlANET, bindData.namePlanet)
            intent.putExtra(PlanetDescription.IMAGE_PLANET, bindData.photoPlanet)
            intent.putExtra(PlanetDescription.DESC_PLANET, bindData.descriptionPlanet)
            holder.itemView.context.startActivity(intent)
        }
    }
}