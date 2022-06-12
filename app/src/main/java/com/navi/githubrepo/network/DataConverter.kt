package com.navi.githubrepo.network

import com.navi.githubrepo.transport.PullRequest
import com.navi.githubrepo.transport.User
import com.navi.githubrepo.model.User as LocalUser
import com.navi.githubrepo.model.PullRequest as LocalPullRequest

object DataConverter {

    fun convertPullRequest(pullRequest: PullRequest) : LocalPullRequest {
        return LocalPullRequest(
            pullRequest.title,
            convertUser(pullRequest.user),
            pullRequest.createdAt,
            pullRequest.closedAt
        )
    }

    private fun convertUser(user: User): LocalUser {
        return LocalUser(user.name, user.avatarUrl)
    }

}