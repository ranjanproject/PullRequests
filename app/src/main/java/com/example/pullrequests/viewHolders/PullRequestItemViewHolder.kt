package com.example.pullrequests.viewHolders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
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
        Glide.with(binding.root)
            .load(userImage)
            .into(binding.profilePicIv);
    }

    private fun setTitle(title: String){
       binding.titleTv.text = title
    }

    private fun setCreatedDate(createdDate: String){
       binding.createdOnDateTv.text = getDate(createdDate)
    }

    private fun setClosedDate(closedDate: String){
       binding.closedOnDateTv.text = getDate(closedDate)
    }

    private fun setCreatedTime(createdDate: String){
        binding.createdOnTimeTv.text = getTime(createdDate)
    }

    private fun setClosedTime(closedDate: String){
        binding.closedOnTimeTv.text = getTime(closedDate)
    }

    private fun getTime(date: String): String{
        var time  = ""

        return time
    }

    private fun getDate(date: String): String{
        var calculatedDate = ""
        return calculatedDate
    }
}