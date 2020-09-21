package com.example.paggingmovie.dataSource.factory

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.paggingmovie.dataSource.MovieDataSource
import com.example.paggingmovie.model.ResultsItem

class MovieDataFactory : DataSource.Factory<Long, ResultsItem>() {

    private var mutableLiveData : MutableLiveData<MovieDataSource> = MutableLiveData()
    private var movieDataSource : MovieDataSource = MovieDataSource()

    override fun create(): DataSource<Long, ResultsItem> {
        mutableLiveData.postValue(movieDataSource)
        return movieDataSource
    }

}