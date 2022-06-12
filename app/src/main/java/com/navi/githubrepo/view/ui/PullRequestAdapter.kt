package com.navi.githubrepo.view.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.navi.githubrepo.R
import com.navi.githubrepo.model.PullRequest

class PullRequestAdapter : RecyclerView.Adapter<PullRequestAdapter.ViewHolder>() {

    private var pullRequests: List<PullRequest> = emptyList()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val userImage: ImageView = view.findViewById(R.id.avatar)
        val titleTextView: TextView = view.findViewById(R.id.title)
        val userName: TextView = view.findViewById(R.id.owner)
        val prCreatedTime: TextView = view.findViewById(R.id.created_at)
        val prClosedTime: TextView = view.findViewById(R.id.closed_at)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.layout_pull_request_row, parent, false
        )

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pullRequest = pullRequests[position]
        val resources = holder.userImage.context.resources
        holder.titleTextView.text = pullRequest.title
        holder.userName.text = pullRequest.user.name
        holder.prCreatedTime.text = resources.getString(R.string.created_at, pullRequest.createdAt.substringBefore("T"))
        holder.prClosedTime.text = resources.getString(R.string.closed_at, pullRequest.createdAt.substringBefore("T"))

        holder.userImage.load(pullRequest.user.avatarUrl) {
            placeholder(R.drawable.pull_request)
            transformations(CircleCropTransformation())
        }
    }

    fun updatePullRequests(pullRequests: List<PullRequest>) {
        this.pullRequests = pullRequests
        this.notifyDataSetChanged()
    }

    override fun getItemCount(): Int = pullRequests.size
}