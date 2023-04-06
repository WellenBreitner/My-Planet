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