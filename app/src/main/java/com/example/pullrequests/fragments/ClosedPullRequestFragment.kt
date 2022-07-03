package com.example.pullrequests.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pullrequests.R
import com.example.pullrequests.adapters.ClosedPullRequestAdapter
import com.example.pullrequests.adapters.ClosedPullRequestItemDecorator
import com.example.pullrequests.databinding.FragmentClosedPullRequestBinding
import com.example.pullrequests.databinding.FragmentUserAndProjectBinding
import com.example.pullrequests.models.PullRequestsList
import com.example.pullrequests.viewModels.ClosedPullRequestViewModel
import com.example.pullrequests.models.PullRequest

class ClosedPullRequestFragment : Fragment() {

    companion object {
        const val USER_NAME = "userName"
        const val REPOSITORY_NAME = "repoName"
        fun newInstance() = ClosedPullRequestFragment()
    }


    private lateinit var binding: FragmentClosedPullRequestBinding
    private val viewModel: ClosedPullRequestViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Retrieve and inflate the layout for this fragment
        binding = FragmentClosedPullRequestBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init(){
        initViewModelObservers()
        initAdapter()
        initRV()
        initNetworkState()
        getClosedPRList()
    }

    private lateinit var adapter: ClosedPullRequestAdapter
    private fun initAdapter(){
        adapter = ClosedPullRequestAdapter(context)
    }

    private fun initRV(){
        binding.apply {
            pullRequestRv.adapter = adapter
            pullRequestRv.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
            pullRequestRv.addItemDecoration(ClosedPullRequestItemDecorator())
        }
    }

    private fun initViewModelObservers(){
        viewModel.closedPRListLiveData.observe(viewLifecycleOwner, Observer {
                onGetClosedPRListResponse(it)
        })
    }

    private fun onGetClosedPRListResponse(response: Any){
        if(response is MutableList<*>){
            hideLoading()
            submitPRList(response)
        }else{
            onNetworkError()
        }
    }

    private fun submitPRList(pullRequestsList: MutableList<*>){
        adapter.submitList(pullRequestsList)
    }

    private fun initNetworkState(){

    }

    private fun onNetworkError(){

    }

    private fun showLoading(){

    }

    private fun hideLoading(){

    }

    private  fun getClosedPRList(){
        viewModel.getClosedPRList(getUserName(), getRepoName())
    }

    private fun getUserName(): String{
        return arguments?.getString(USER_NAME)!!
    }

    private fun getRepoName(): String{
        return arguments?.getString(REPOSITORY_NAME)!!
    }

}