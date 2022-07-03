package com.example.pullrequests.models

import retrofit2.Response

data class PullRequestListResponse(
    val response: Response<PullRequestsList>
)
