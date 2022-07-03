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
import com.example.pullrequests.R
import com.example.pullrequests.databinding.FragmentClosedPullRequestBinding
import com.example.pullrequests.databinding.FragmentUserAndProjectBinding
import com.example.pullrequests.viewModels.ClosedPullRequestViewModel

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
         viewModel.getClosedPRList(getUserName(), getRepoName())
    }

    private fun initRV(){

    }

    private fun initViewModelObservers(){
        viewModel.closedPRListLiveData?.observe(viewLifecycleOwner, Observer {
            val x = it
        })
    }

    private fun initNetworkState(){

    }

    private fun getUserName(): String{
        return arguments?.getString(USER_NAME)!!
    }

    private fun getRepoName(): String{
        return arguments?.getString(REPOSITORY_NAME)!!
    }

}