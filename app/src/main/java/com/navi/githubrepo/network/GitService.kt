package com.navi.githubrepo.network

import androidx.annotation.WorkerThread
import com.navi.githubrepo.model.PullRequest
import java.io.IOException
import javax.inject.Inject

@WorkerThread
interface GitService {
    suspend fun fetchClosedPullRequest(owner: String, repo: String): List<PullRequest>
}

class GitServiceImpl @Inject constructor(
    private val gitRepoApi: GitRepoApi
) : GitService {

    @Throws(IOException::class)
    override suspend fun fetchClosedPullRequest(
        owner: String,
        repo: String
    ): List<PullRequest> {
        val pullRequestCall = gitRepoApi.getAllPullRequestsByState(
            owner, repo, "closed"
        )
        val pullRequestResponse = pullRequestCall.execute()
        val pullRequests = mutableListOf<PullRequest>()
        if (pullRequestResponse.isSuccessful) {
            pullRequestResponse.body()?.let { pullRequestsData ->
                pullRequestsData.forEach {
                    val convertedData = DataConverter.convertPullRequest(it)
                    pullRequests.add(convertedData)
                }
            }
        }
        return pullRequests
    }
}