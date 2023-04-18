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

class GridVerticalAdapter(
    private val listPlanet: ArrayList<DataPlanet>
) : RecyclerView.Adapter<GridVerticalAdapter.GridViewHolder>() {
    class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textName: TextView = itemView.findViewById(R.id.gridVerticalNameOfPlanet)
        val image: ImageView = itemView.findViewById(R.id.gridVerticalImageOfPlanet)
        val cardView: CardView = itemView.findViewById(R.id.gridPlanetVerticalCardView)
        val temperature: ImageView = itemView.findViewById(R.id.gridVerticalTemperatureImage)
        val rotation: ImageView = itemView.findViewById(R.id.gridVerticalRotationImage)
        val diameter: ImageView = itemView.findViewById(R.id.gridVerticalDiameterImage)
        val distance: ImageView = itemView.findViewById(R.id.gridVerticalDistanceImage)
        val temperatureText: TextView = itemView.findViewById(R.id.gridVerticalTemperatureText)
        val rotationText: TextView = itemView.findViewById(R.id.gridVerticalRotationText)
        val diameterText: TextView = itemView.findViewById(R.id.gridVerticalDiameterText)
        val distanceText: TextView = itemView.findViewById(R.id.gridVerticalDistanceText)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        return GridViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.gridplanetverticalitem, parent, false)
        )
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        val bindData = listPlanet[position]
        holder.textName.text = bindData.namePlanet
        holder.image.setImageResource(bindData.photoPlanet)
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
                holder.itemView.context,
                androidx.appcompat.R.anim.abc_slide_in_bottom
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

    override fun getItemCount() = listPlanet.size
}