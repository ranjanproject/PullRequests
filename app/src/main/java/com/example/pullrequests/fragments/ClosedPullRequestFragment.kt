package com.example.pullrequests.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.pullrequests.R
import com.example.pullrequests.databinding.FragmentClosedPullRequestBinding
import com.example.pullrequests.databinding.FragmentUserAndProjectBinding

class ClosedPullRequestFragment : Fragment() {

    companion object {
        const val USER_NAME = "userName"
        const val REPOSITORY_NAME = "repoName"
        fun newInstance() = ClosedPullRequestFragment()
    }


    private lateinit var binding: FragmentClosedPullRequestBinding
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

    }


}