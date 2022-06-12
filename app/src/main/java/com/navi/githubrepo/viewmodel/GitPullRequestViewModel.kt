package com.navi.githubrepo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.navi.githubrepo.model.PullRequest
import com.navi.githubrepo.repo.GitPullRequestRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GitPullRequestViewModel @Inject constructor(
    private val gitPullRequestRepo: GitPullRequestRepo
) : ViewModel() {

    private val pullRequestsLiveData = MutableLiveData<List<PullRequest>>()

    init {
        fetchPullRequests()
    }

    private fun fetchPullRequests() {
        viewModelScope.launch(Dispatchers.IO) {
            val closedPullRequests = gitPullRequestRepo.getClosedPullRequest(
                "dinu005",
                "GithubRepo"
            )
            pullRequestsLiveData.postValue(closedPullRequests)
        }
    }

    fun pullRequestsData(): LiveData<List<PullRequest>> {
        return pullRequestsLiveData
    }

}