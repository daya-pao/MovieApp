package com.example.movieapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.Api.RetrofitServiceApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class GeneralFragment : Fragment() {
    private lateinit var adapterMovie: AdapterMovie
    private lateinit var recyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_general,container,false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recycleMv)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val service = RetrofitServiceApi.maleMovie()
        try {
            lifecycleScope.launch {
                val listMovie = service.listPopular("100edd35a600d96c8451951d2a582e76").results
                withContext(Dispatchers.Main){
                    adapterMovie = AdapterMovie(listMovie,this@GeneralFragment)
                    recyclerView.adapter = adapterMovie
                }
            }
        }catch (e: Exception){

        }

    }

}