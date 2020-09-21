package com.example.paggingmovie.network

import com.example.paggingmovie.model.Movie
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("lists")
    fun getMovie(@Query("api_key") api : String,
    @Query("page") page : Long,
    @Query("pageSize") pageSize : Int):Flowable<Movie>

}