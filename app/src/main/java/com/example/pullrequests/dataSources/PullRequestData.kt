package com.example.pullrequests.dataSources

import com.example.pullrequests.models.PullRequest
import com.example.pullrequests.models.PullRequestsList

class PullRequestData {

    fun getClosedPullRequestList(pullRequestsList: PullRequestsList): MutableList<PullRequest>{

        return pullRequestsList.pullRequestsItemList
    }
}