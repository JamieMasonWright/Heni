package com.heni.composeview.network

import com.heni.composeview.network.data.RepoResponse

interface RemoteRepository {
    suspend fun getRepos(): List<RepoResponse>?
}