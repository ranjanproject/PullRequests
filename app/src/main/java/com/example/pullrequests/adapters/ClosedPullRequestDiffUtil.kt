package com.example.pullrequests.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.pullrequests.models.PullRequest

class ClosedPullRequestDiffUtil: DiffUtil.ItemCallback<Any>() {
    override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
        var areItemSame = true

        if(oldItem is PullRequest && newItem is PullRequest){
            areItemSame = true
        }

        return areItemSame
    }

    override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
        var areContentSame = true

        if(oldItem is PullRequest && newItem is PullRequest){
            areContentSame = (oldItem.closedDate == newItem.closedDate) &&
                    (oldItem.user.userName == newItem.user.userName) &&
                    (oldItem.user.userImage == newItem.user.userImage)
                    (oldItem.title == newItem.title) &&
                    (oldItem.createdDate == newItem.createdDate)
        }

        return areContentSame
    }
}