package com.example.paggingmovie.dataSource

import androidx.paging.PageKeyedDataSource
import com.example.paggingmovie.model.ResultsItem
import com.example.paggingmovie.network.MovieService
import com.example.paggingmovie.network.ResApi
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MovieDataSource: PageKeyedDataSource<Long, ResultsItem>(){

    private var api : MovieService = ResApi.resApi()

    override fun loadInitial(
        params: LoadInitialParams<Long>,
        callback: LoadInitialCallback<Long, ResultsItem>
    ) {

        api.getMovie("b64d761def5c00e40e6a36e0032741bf",1,params.requestedLoadSize)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                t ->
                t.results?.let { callback.onResult(it,null,2L) }
            },{

            })

    }

    override fun loadAfter(params: LoadParams<Long>, callback: LoadCallback<Long, ResultsItem>) {
        api.getMovie("b64d761def5c00e40e6a36e0032741bf",params.key,params.requestedLoadSize)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                    t ->
                t.results?.let { callback.onResult(it,params.key + 1L) }
            },{

            })
    }

    override fun loadBefore(params: LoadParams<Long>, callback: LoadCallback<Long, ResultsItem>) {
    }

}