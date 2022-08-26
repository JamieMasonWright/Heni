package com.heni.composeview.network

import com.heni.composeview.network.data.RepoResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetRepoUseCase @Inject constructor(
    private val remoteRepository: RemoteRepository
) {

    operator fun invoke(): Flow<List<RepoResponse>?> = flow {
        try {
            emit(remoteRepository.getRepos())
        } catch (exception: Exception) {
            println(exception)
        }
    }
}