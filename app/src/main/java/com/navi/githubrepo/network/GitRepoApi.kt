package com.navi.githubrepo.network

import com.navi.githubrepo.transport.PullRequest
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface GitRepoApi {

    @GET("/repos/{owner}/{repo}/pulls")
    fun closedPullRequest(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("state") state: String = "closed",
        @Header("Authorization") authorization: String,
        @Header("Accept") accept: String = "application/vnd.github.v3+json"
    ): Call<List<PullRequest>>

}