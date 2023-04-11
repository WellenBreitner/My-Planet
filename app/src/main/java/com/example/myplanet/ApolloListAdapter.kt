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

class ApolloListAdapter(
    private val listData: ArrayList<DataApollo>
) : RecyclerView.Adapter<ApolloListAdapter.ApolloListViewHolder>() {
    class ApolloListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView: CardView = itemView.findViewById(R.id.listApolloCardView)
        val imageView: ImageView = itemView.findViewById(R.id.apolloCircleImage)
        val name: TextView = itemView.findViewById(R.id.apolloListName)
        val desc: TextView = itemView.findViewById(R.id.apolloListDesc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApolloListViewHolder {
        return ApolloListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.listitemapollo, parent, false)
        )
    }

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ApolloListViewHolder, position: Int) {
        val bind = listData[position]

        holder.imageView.setImageResource(bind.photoAppolo)
        holder.name.text = bind.nameApollo
        holder.desc.text = bind.descApollo

        holder.cardView.startAnimation(
            AnimationUtils.loadAnimation(
                holder.cardView.context,
                com.airbnb.lottie.R.anim.abc_slide_in_bottom
            )
        )

        holder.cardView.setOnClickListener {
            val intent = Intent(holder.itemView.context, ApolloDescription::class.java)
            intent.putExtra(ApolloDescription.NAME_APOLLO, bind.nameApollo)
            intent.putExtra(ApolloDescription.DESC_APOLLO, bind.descApollo)
            intent.putExtra(ApolloDescription.IMAGE_APOLLO, bind.photoAppolo)
            holder.itemView.context.startActivity(intent)

        }
    }
}