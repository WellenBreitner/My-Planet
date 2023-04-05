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

        holder.cardView.startAnimation(
            AnimationUtils.loadAnimation(
                holder.cardView.context,
                com.airbnb.lottie.R.anim.abc_slide_in_bottom
            )
        )

        holder.cardView.setOnClickListener {
            val intent = Intent(holder.itemView.context, Description::class.java)
            intent.putExtra(Description.NAME_PlANET, bindData.namePlanet)
            intent.putExtra(Description.IMAGE_PLANET, bindData.photoPlanet)
            intent.putExtra(Description.DESC_PLANET, bindData.descriptionPlanet)
            holder.itemView.context.startActivity(intent)
        }
    }
}