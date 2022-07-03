package com.example.pullrequests.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pullrequests.models.PullRequest
import com.example.pullrequests.viewHolders.PullRequestItemViewHolder

class ClosedPullRequestAdapter(private val context: Context?):
    ListAdapter<Any, RecyclerView.ViewHolder>(ClosedPullRequestDiffUtil()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var viewHolder: RecyclerView.ViewHolder? = null
        val inflater = LayoutInflater.from(context)
        when(viewType){
              PullRequestItemViewHolder.ITEM_PULL_REQUEST ->
                  viewHolder = PullRequestItemViewHolder.create(inflater, parent)
        }

        return viewHolder!!
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        when(holder){
            is PullRequestItemViewHolder -> holder.setDataInView(item as PullRequest)
        }
    }

    override fun getItemViewType(position: Int): Int {
        super.getItemViewType(position)
        val item = getItem(position)
        var viewType = 0
        when(item){
            is PullRequest -> viewType = PullRequestItemViewHolder.ITEM_PULL_REQUEST
        }
        return viewType
    }
}