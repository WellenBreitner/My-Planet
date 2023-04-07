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
) : RecyclerView.Adapter<AstronautListAdapter.AstronautListViewHodler>() {
    class AstronautListViewHodler(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView: CardView = itemView.findViewById(R.id.listAstronautCardView)
        val circleImage: CircleImageView = itemView.findViewById(R.id.astronautCircleImage)
        val name: TextView = itemView.findViewById(R.id.astronautName)
        val desc: TextView = itemView.findViewById(R.id.astronautDesc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AstronautListViewHodler {
        return AstronautListViewHodler(
            LayoutInflater.from(parent.context).inflate(R.layout.listastronaut, parent, false)
        )
    }

    override fun getItemCount() = listAstronaut.size

    override fun onBindViewHolder(holder: AstronautListViewHodler, position: Int) {
        val bind = listAstronaut[position]
        holder.circleImage.setImageResource(bind.PhotoAstronaut)
        holder.name.text = bind.nameAstronaut
        holder.desc.text = bind.descAstronaut

        holder.cardView.setOnClickListener {
            val intent = Intent(holder.itemView.context, AstronautDescription::class.java)
            intent.putExtra(AstronautDescription.NAME_ASTRONAUT, bind.nameAstronaut)
            intent.putExtra(AstronautDescription.IMAGE_ASTRONAUT, bind.PhotoAstronaut)
            intent.putExtra(AstronautDescription.DESC_ASTRONAUT, bind.descAstronaut)
            holder.itemView.context.startActivity(intent)
        }
    }
}