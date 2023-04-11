package com.example.myplanet

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class AstronautListAdapter(
    private val listAstronaut: ArrayList<DataAstronaut>
) : RecyclerView.Adapter<AstronautListAdapter.AstronautListViewHolder>() {
    class AstronautListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView: CardView = itemView.findViewById(R.id.listAstronautCardView)
        val circleImage: CircleImageView = itemView.findViewById(R.id.astronautCircleImage)
        val name: TextView = itemView.findViewById(R.id.astronautListName)
        val desc: TextView = itemView.findViewById(R.id.astronautListDescription)
        val apollo: TextView = itemView.findViewById(R.id.data_Apollo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AstronautListViewHolder {
        return AstronautListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.listastronaut, parent, false)
        )
    }

    override fun getItemCount() = listAstronaut.size

    override fun onBindViewHolder(holder: AstronautListViewHolder, position: Int) {
        val bind = listAstronaut[position]
        holder.circleImage.setImageResource(bind.photoAstronaut)
        holder.name.text = bind.nameAstronaut
        holder.apollo.text = bind.DataApollo
        holder.desc.text = bind.descAstronaut
//
//        holder.cardView.startAnimation(
//            AnimationUtils.loadAnimation(
//                holder.cardView.context,
//                com.airbnb.lottie.R.anim.abc_slide_in_bottom
//            )
//        )

        holder.cardView.setOnClickListener {
            val intent = Intent(holder.itemView.context, AstronautDescription::class.java)
            intent.putExtra(AstronautDescription.NAME_ASTRONAUT, bind.nameAstronaut)
            intent.putExtra(AstronautDescription.IMAGE_ASTRONAUT, bind.photoAstronaut)
            intent.putExtra(AstronautDescription.DESC_ASTRONAUT, bind.descAstronaut)
            holder.itemView.context.startActivity(intent)
        }
    }
}