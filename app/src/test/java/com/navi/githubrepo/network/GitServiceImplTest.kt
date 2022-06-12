package com.navi.githubrepo.network

import com.navi.githubrepo.transport.PullRequest
import com.navi.githubrepo.transport.User
import junit.framework.Assert
import kotlinx.coroutines.runBlocking
import okhttp3.Request
import okio.Timeout
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.eq
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@RunWith(MockitoJUnitRunner::class)
class GitServiceImplTest {

    @Mock
    lateinit var gitRepoApi: GitRepoApi

    @Test
    fun `test success`() {
        val owner = "owner"
        val repo = "repo"
        val call = mockCall()
        Mockito.`when`(gitRepoApi.getAllPullRequestsByState(
            eq(owner), eq(repo), eq("closed"))).thenReturn(call)

        val pullRequests = runBlocking {
            GitServiceImpl(gitRepoApi).fetchClosedPullRequest(
                owner, repo
            )
        }
        Assert.assertEquals(2, pullRequests.size)
    }


    private fun mockCall() : Call<List<PullRequest>> {
        return object: Call<List<PullRequest>> {
            override fun clone(): Call<List<PullRequest>> {
                TODO("Not yet implemented")
            }

            override fun execute(): Response<List<PullRequest>> {
                val user = User("sample", "google.com")
                val pr1 = PullRequest("Test 1", user, "2020-10-10", "2020-10-10")
                val pr2 = PullRequest("Test 1", user, "2020-10-11", "2020-10-12")
                val result = mutableListOf(pr1, pr2)
                return Response.success(result)
            }

            override fun enqueue(callback: Callback<List<PullRequest>>) {
                TODO("Not yet implemented")
            }

            override fun isExecuted(): Boolean {
                return true
            }

            override fun cancel() {
                TODO("Not yet implemented")
            }

            override fun isCanceled(): Boolean {
                TODO("Not yet implemented")
            }

            override fun request(): Request {
                TODO("Not yet implemented")
            }

            override fun timeout(): Timeout {
                TODO("Not yet implemented")
            }
        }
    }

}