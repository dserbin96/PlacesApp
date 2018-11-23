package com.example.dns.placesapp.presentation.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.dns.placesapp.R
import io.rmiri.skeleton.Master.AdapterSkeleton
import io.rmiri.skeleton.Master.IsCanSetAdapterListener
import kotlinx.android.synthetic.main.item_view_photo.view.*

class PhotoPlaceAdapter() : AdapterSkeleton<String, PhotoPlaceAdapter.PhotoViewHolder>() {

    constructor(context: Context,
                recyclerView: RecyclerView,
                list: List<String>,
                listener: IsCanSetAdapterListener) : this() {
        this.context = context
        this.items = list
        this.isCanSetAdapterListener = listener

        measureHeightRecyclerViewAndItem(recyclerView, R.layout.item_view_photo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PhotoViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view_photo, parent, false))

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bindView(items[position])
    }

    class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(imagePath: String) {
            Glide.with(itemView).load(imagePath).into(itemView.ivPhoto)
        }
    }

}