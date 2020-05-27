package com.example.contohrecyclerview.util

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.contohrecyclerview.DetailActivity
import com.example.contohrecyclerview.R
import com.example.contohrecyclerview.model.Movie
import kotlinx.android.synthetic.main.item_list.view.*

class ListAdapter(private val list: List<Movie>) :
    RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: Movie) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(data.poster)
                    .apply(RequestOptions().override(60, 60))
                    .into(civ_poster)

                tv_title?.text = data.title
                tv_genre?.text = data.genre
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder =
        ListViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_list, parent, false)
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(list[position])

        val movies = list[position]
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_DATA, movies)

            holder.itemView.context.startActivity(intent)
        }
    }
}