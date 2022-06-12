package com.navi.githubrepo.model

data class PullRequest(
    val title: String,
    val user: User,
    val createdAt: String,
    val closedAt: String
)
