package com.example.pullrequests.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pullrequests.models.PullRequest
import com.example.pullrequests.models.PullRequestsList
import com.example.pullrequests.repositories.PullRequestRepository
import kotlinx.coroutines.launch

class ClosedPullRequestViewModel : ViewModel() {
    var closedPRListLiveData = MutableLiveData<Any>()

    private val repository = PullRequestRepository()

    fun getClosedPRList(userName: String, repoName: String){
        viewModelScope.launch {
            try {
               val response = repository.getClosedPullRequestList(userName, repoName)
                onGetClosedPRListResponse(response)
            }catch (e: Exception){
                onGetClosedPRListResponse(e)
            }
        }
    }

    private fun onGetClosedPRListResponse(response: Any?){
        closedPRListLiveData.value = response as MutableList<PullRequest>
    }
}