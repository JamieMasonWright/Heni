package com.heni.composeview.network

import com.heni.composeview.network.data.RepoResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("users/mralexgray/repos")
    suspend fun getRepoList(): Response<List<RepoResponse>>

}