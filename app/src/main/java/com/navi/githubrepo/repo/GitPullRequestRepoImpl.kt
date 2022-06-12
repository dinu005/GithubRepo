package com.navi.githubrepo.repo

import com.navi.githubrepo.model.PullRequest
import com.navi.githubrepo.network.GitService
import javax.inject.Inject

interface GitPullRequestRepo {
    suspend fun getClosedPullRequest(
        owner: String,
        repo: String
    ): List<PullRequest>
}

class GitPullRequestRepoImpl @Inject constructor(
    private val gitService: GitService
) : GitPullRequestRepo {

    override suspend fun getClosedPullRequest(
        owner: String,
        repo: String
    ): List<PullRequest> {
        return gitService.fetchClosedPullRequest(
            owner, repo
        )
    }
}