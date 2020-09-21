package com.example.paggingmovie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.paggingmovie.adapter.MovieAdapter
import com.example.paggingmovie.viewmodel.MovieViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var movieViewModel : MovieViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movieViewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)
        movieViewModel?.getMovie()


        movieViewModel?.resultData?.observe(this, {
            val adapter = MovieAdapter()
            adapter.submitList(it)
            listMovie.adapter = adapter
        })

    }
}