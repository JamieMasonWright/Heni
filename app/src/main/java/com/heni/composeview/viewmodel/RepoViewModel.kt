package com.heni.composeview.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.heni.composeview.network.GetRepoUseCase
import com.heni.composeview.network.data.RepoResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class RepoViewModel @Inject constructor(
    private val getRepoUseCase: GetRepoUseCase
) : ViewModel() {

    private val _repoListStatus: MutableState<List<RepoResponse>> = mutableStateOf(ArrayList())

    val repoListStatus: State<List<RepoResponse>>
        get() = _repoListStatus

    init {
        getRepoList()
    }

    private fun getRepoList() {
        val res = getRepoUseCase()
        res.onEach {
            if (it != null) {
                _repoListStatus.value = it
            }
            println(it)
        }.launchIn(viewModelScope)
    }
}