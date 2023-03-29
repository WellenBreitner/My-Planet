package com.example.myplanet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class GridHorizontalAdapter(
    private val listPlanet : ArrayList<Dataplanet>
    ): RecyclerView.Adapter<GridHorizontalAdapter.GridViewHolder>() {
    class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textName: TextView = itemView.findViewById(R.id.gridHorizontalNameOfPlanet)
        val image: ImageView = itemView.findViewById(R.id.gridHorizontalImageOfPlanet)
        val cardView: CardView = itemView.findViewById(R.id.gridHorizontalCardView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        return GridViewHolder (LayoutInflater.from(parent.context).inflate(R.layout.gridhorizontalitem,parent,false))
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        val bindData = listPlanet[position]
        holder.textName.text = bindData.namePlanet
        holder.image.setImageResource(bindData.photoPlanet)

        holder.cardView.startAnimation(
            AnimationUtils.loadAnimation(
            holder.itemView.context,
            androidx.appcompat.R.anim.abc_slide_in_bottom))
    }

    override fun getItemCount() = listPlanet.size
}