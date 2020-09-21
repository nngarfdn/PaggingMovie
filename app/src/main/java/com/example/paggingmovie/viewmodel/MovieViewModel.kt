package com.example.paggingmovie.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.paggingmovie.dataSource.factory.MovieDataFactory
import com.example.paggingmovie.model.ResultsItem
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class MovieViewModel: ViewModel() {

    private var exuxutor : Executor = Executors.newFixedThreadPool(5)
    var resultData : LiveData<PagedList<ResultsItem>>

    init {

        val movieFactory = MovieDataFactory()

        val pageListConfig = PagedList.Config.Builder()
            .setPageSize(20)
            .setInitialLoadSizeHint(10)
            .setEnablePlaceholders(false)
            .build()

        resultData = LivePagedListBuilder(movieFactory,pageListConfig)
            .setFetchExecutor(exuxutor)
            .build()
    }

    fun getMovie() : LiveData<PagedList<ResultsItem>>{
        return resultData
    }
}