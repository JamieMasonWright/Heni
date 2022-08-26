package com.heni.composeview.network

import com.heni.composeview.network.data.RepoResponse
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : RemoteRepository {

    override suspend fun getRepos(): List<RepoResponse>? {
        return getRepoList()
    }

    private suspend fun getRepoList(): List<RepoResponse>? {
        val response = apiService.getRepoList()
        if (response.isSuccessful) {
            return response.body()
        }
        return null
    }
}