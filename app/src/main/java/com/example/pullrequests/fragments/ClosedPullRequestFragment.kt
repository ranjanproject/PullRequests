package com.example.pullrequests.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pullrequests.R

class ClosedPullRequestFragment : Fragment() {

    companion object {
        fun newInstance() = ClosedPullRequestFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_closed_pull_request, container, false)
    }

}