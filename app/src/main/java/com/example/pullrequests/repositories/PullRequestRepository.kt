package com.example.pullrequests.repositories

import com.example.pullrequests.dataSources.PullRequestData
import com.example.pullrequests.models.PullRequest
import com.example.pullrequests.models.PullRequestsList
import com.example.pullrequests.network.RetrofitHelper
import com.example.pullrequests.services.PullRequestsAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import retrofit2.Response

class PullRequestRepository {

    private val retrofitApi = RetrofitHelper.getInstance().create(PullRequestsAPI::class.java)

    suspend fun getClosedPullRequestList(userName: String, repoName: String): MutableList<PullRequest>?{
        return withContext(Dispatchers.IO){

            val pullRequestsListResponse = async {
                retrofitApi.getClosedPullRequests(userName, repoName)
            }

            return@withContext onGetClosedPullRequestList(pullRequestsListResponse.await())
        }
    }

    private fun onGetClosedPullRequestList(pullRequestsListResponse: Response<PullRequestsList>):
            MutableList<PullRequest>?{

        return PullRequestData().getClosedPullRequestList(pullRequestsListResponse)

    }
}