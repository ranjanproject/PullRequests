package com.example.pullrequests.viewHolders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pullrequests.R
import com.example.pullrequests.databinding.ItemPullRequestBinding
import com.example.pullrequests.models.PullRequest

class PullRequestItemViewHolder(private val binding: ItemPullRequestBinding): RecyclerView.ViewHolder(binding.root) {
    companion object{
        const val ITEM_PULL_REQUEST = R.layout.item_pull_request
        fun create(inflater: LayoutInflater,
                   parent: ViewGroup
        ): PullRequestItemViewHolder{
            val binding = ItemPullRequestBinding.inflate(inflater, parent, false)
            return PullRequestItemViewHolder(binding)
        }
    }

    fun setDataInView(pullRequest: PullRequest){
        setUserName(pullRequest.user.userName)
        setUserImage(pullRequest.user.userImage)
        setTitle(pullRequest.title)
        setCreatedDate(pullRequest.createdDate)
        setClosedDate(pullRequest.closedDate)
    }

    private fun setUserName(userName: String){
        binding.userNameTv.text = userName
    }

    private fun setUserImage(userImage: String){

    }

    private fun setTitle(title: String){
       binding.titleTv.text = title
    }

    private fun setCreatedDate(createdDate: String){
       binding.createdOnDateTv.text = createdDate
    }

    private fun setClosedDate(closedDate: String){
       binding.closedOnDateTv.text = closedDate
    }
}