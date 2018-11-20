package com.example.dns.placesapp.presentation.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dns.placesapp.R
import com.example.dns.placesapp.presentation.global.model.PlaceViewModel

class PlacesAdapter : RecyclerView.Adapter<PlacesAdapter.PlaceViewHolder>() {

    private val list = mutableListOf<PlaceViewModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder =
            PlaceViewHolder(LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_page_places, parent, false))

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        holder.bindItem(list[position])
    }

    fun setList(list: List<PlaceViewModel>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    class PlaceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(model: PlaceViewModel) {
            /*with(itemView){
                Glide.with(this).load(model.imagePath).into(ivPlace)
                tvName.text = model.name
                tvAdress.text = model.adress
                tvTimeWork.text = model.timeWork
                ivMap.setOnClickListener {
                    Toast.makeText(this.context,"MAP",Toast.LENGTH_SHORT).show()
                }
                tbFavorite.isChecked = model.isFavorites
            }*/
        }
    }

}