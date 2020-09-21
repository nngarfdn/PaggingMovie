package com.example.paggingmovie.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.paggingmovie.R
import com.example.paggingmovie.model.ResultsItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieAdapter : PagedListAdapter<ResultsItem,RecyclerView.ViewHolder>(DIFF_CALLBACK){

    companion object {
        var DIFF_CALLBACK: DiffUtil.ItemCallback<ResultsItem> = object : DiffUtil.ItemCallback<ResultsItem>() {
            override fun areItemsTheSame(oldItem: ResultsItem, newItem: ResultsItem): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: ResultsItem, newItem: ResultsItem): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie,parent,false)
        return MovieHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MovieHolder){
            holder.bindTo(getItem(position))
        }
    }

    class MovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindTo(item: ResultsItem?) {
            itemView.txt_name.text = item?.name
            itemView.txt_list_type.text = item?.listType
            itemView.txt_description.text = item?.description
            Picasso.get().load("https://image.tmdb.org/t/p/w500${item?.posterPath}")
                .placeholder(R.drawable.ic_baseline_broken_image_24)
                .into(itemView.img_view)
        }

    }

}


