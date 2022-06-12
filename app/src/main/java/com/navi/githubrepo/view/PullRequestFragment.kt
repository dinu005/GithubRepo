package com.navi.githubrepo.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.navi.githubrepo.R
import com.navi.githubrepo.model.PullRequest
import com.navi.githubrepo.view.ui.PullRequestAdapter
import com.navi.githubrepo.viewmodel.GitPullRequestViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * A simple [Fragment] subclass.
 * Use the [PullRequestFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

@AndroidEntryPoint
class PullRequestFragment : Fragment() {

    private val viewModel: GitPullRequestViewModel by viewModels()
    private val adapter by lazy {
        PullRequestAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pull_request, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.pull_requests_recycler)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }


    override fun onResume() {
        super.onResume()

        viewModel.pullRequestsData().observe(this) { pullRequests ->
            pullRequests?.let {
                adapter.updatePullRequests(it)
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment PullRequestFragment.
         */
        @JvmStatic
        fun newInstance() = PullRequestFragment()
    }
}