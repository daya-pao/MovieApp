package com.example.movieapp.Api

import com.example.movieapp.Api.Model.RemoteResults
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitApi {
    @GET("3/movie/popular")
    suspend fun  listPopular(
        @Query("api_key") apikey:String
    ):RemoteResults
}

object RetrofitServiceApi{
    fun maleMovie():RetrofitApi{
        return  Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitApi::class.java)
    }
}