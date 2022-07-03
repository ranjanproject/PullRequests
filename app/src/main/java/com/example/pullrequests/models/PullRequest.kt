package com.example.pullrequests.models

import com.google.gson.annotations.SerializedName

data class PullRequest(
    val user: User,
    val title: String,
    @SerializedName("created_at")
    val createdDate: String,
    @SerializedName("closed_at")
    val closedDate: String
)
