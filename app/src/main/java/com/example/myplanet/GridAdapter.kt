package com.example.myplanet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class GridAdapter(
    private val listPlanet : ArrayList<Dataplanet>
    ): RecyclerView.Adapter<GridAdapter.GridViewHolder>() {
    class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textName = itemView.findViewById<TextView>(R.id.nameOfPlanet)
        val image = itemView.findViewById<ImageView>(R.id.imageOfPlanet)
        val cardview = itemView.findViewById<CardView>(R.id.cardView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        return GridViewHolder (LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false))
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        val bindData = listPlanet[position]
        holder.textName.text = bindData.namePlanet
        holder.image.setImageResource(bindData.photoPlanet)

        holder.cardview.startAnimation(
            AnimationUtils.loadAnimation(
            holder.itemView.context,
            androidx.appcompat.R.anim.abc_slide_in_bottom))
    }

    override fun getItemCount() = listPlanet.size
}