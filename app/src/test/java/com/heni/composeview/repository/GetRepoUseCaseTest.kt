package com.heni.composeview.repository

import com.heni.composeview.mockRepoData
import com.heni.composeview.network.GetRepoUseCase
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GetRepoUseCaseTest {

    private val fakeRepoRepository = FakeRepoRepository()
    private val getRepoUseCase = GetRepoUseCase(fakeRepoRepository)

    @Test
    fun `should get popular movies correctly`() {
        runBlocking {
            val actual = getRepoUseCase().toList().first()
            val expected = listOf(mockRepoData())
            assertEquals(expected, actual)
        }
    }
}