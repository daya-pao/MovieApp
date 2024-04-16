package com.example.movieapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.Api.Model.ResultMV


class AdapterMovie(private  val  movie: List<ResultMV>,generalFragment: GeneralFragment) :
    RecyclerView.Adapter<AdapterMovie.ViewHolder>(){

    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val texto :TextView = view.findViewById(R.id.txtMV)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movies,parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder:  ViewHolder, position: Int) {

        val listM = movie[position]
        holder.texto.text = listM.title
    }

    override fun getItemCount(): Int {
        return movie.size
    }

}
