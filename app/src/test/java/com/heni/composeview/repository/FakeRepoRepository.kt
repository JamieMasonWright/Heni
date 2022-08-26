package com.heni.composeview.repository

import com.heni.composeview.mockRepoData
import com.heni.composeview.network.RemoteRepository
import com.heni.composeview.network.data.RepoResponse

class FakeRepoRepository : RemoteRepository {
    override suspend fun getRepos(): List<RepoResponse>? {
        return listOf(mockRepoData())
    }
}