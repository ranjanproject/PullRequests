package com.example.pullrequests.dataSources

import com.example.pullrequests.models.PullRequest
import com.example.pullrequests.models.PullRequestsList
import retrofit2.Response

class PullRequestData {

    fun getClosedPullRequestList(pullRequestsListResponse: Response<PullRequestsList>):
            MutableList<PullRequest>?{
           return pullRequestsListResponse.body()?.toMutableList()
    }
}