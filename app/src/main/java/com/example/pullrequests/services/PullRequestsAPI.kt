package com.example.pullrequests.services

import com.example.pullrequests.models.PullRequestsList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PullRequestsAPI {
    @GET("{owner}/{repo}/pulls")
    suspend fun getClosedPullRequests(
        @Path("owner") userName: String,
        @Path("repo") repository: String,
        @Query("state") state: String = "closed"
    ): Response<PullRequestsList>
}