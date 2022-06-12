package com.navi.githubrepo.transport

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class User(
    @SerializedName("login") val name: String,
    @SerializedName("avatar_url") val avatarUrl: String,
): Serializable
