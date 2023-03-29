package com.example.myplanet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter (private val listPlanet : ArrayList<Dataplanet>): RecyclerView.Adapter<ListAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView : TextView = itemView.findViewById(R.id.listNameOfPlanet)
        val imageView : ImageView = itemView.findViewById(R.id.listImageOfPlanet)
        val cardView : CardView = itemView.findViewById(R.id.listCardView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.listitem,parent,false))
    }

    override fun getItemCount() = listPlanet.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val bind = listPlanet[position]
        holder.imageView.setImageResource(bind.photoPlanet)
        holder.textView.text = bind.namePlanet

        holder.cardView.startAnimation(
            AnimationUtils.loadAnimation(
                holder.cardView.context,
                com.airbnb.lottie.R.anim.abc_slide_in_bottom
            )
        )
    }
}