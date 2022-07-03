package com.example.pullrequests.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.pullrequests.R
import com.example.pullrequests.databinding.FragmentUserAndProjectBinding

class UserAndProjectFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = UserAndProjectFragment()
    }

    private lateinit var binding: FragmentUserAndProjectBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentUserAndProjectBinding.inflate(inflater,container,  false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init(){
        initializeUserName()
        initializeRepositoryName()
        initializeGetClosedPRButton()
    }

    private fun initializeUserName(){
        binding.userNameEt.setText(R.string.default_user_name)
    }

    private fun initializeRepositoryName(){
        binding.projectNameEt.setText(R.string.default_repository)
    }

    private fun initializeGetClosedPRButton(){

        binding.getClosedPrBtn.setOnClickListener {
            findNavController().navigate(R.id.action_userAndProjectFragment_to_closedPullRequestFragment)
        }
    }
}