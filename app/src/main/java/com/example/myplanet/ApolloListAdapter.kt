package com.example.myplanet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ApolloListAdapter(
    private val listData: ArrayList<DataApollo>
) : RecyclerView.Adapter<ApolloListAdapter.ApolloListViewHolder>() {
    class ApolloListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
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
    }
}