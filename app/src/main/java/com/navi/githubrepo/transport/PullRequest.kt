package com.navi.githubrepo.transport

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class PullRequest(
    @SerializedName("title") val title: String,
    @Expose @SerializedName("user") val user: User,
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("closed_at") val closedAt: String
): Serializable
