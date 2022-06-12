package com.navi.githubrepo.di

import com.navi.githubrepo.network.GitRepoApi
import com.navi.githubrepo.network.GitService
import com.navi.githubrepo.network.GitServiceImpl
import com.navi.githubrepo.repo.GitPullRequestRepo
import com.navi.githubrepo.repo.GitPullRequestRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
object GitRepoModule {

    @Provides
    fun providesGitRepoApi(retrofit: Retrofit): GitRepoApi {
        return retrofit.create(GitRepoApi::class.java)
    }

    @Provides
    fun providesGitService(gitRepoApi: GitRepoApi) : GitService {
        return GitServiceImpl(gitRepoApi)
    }

    @Provides
    fun providesGitRepository(gitService: GitService): GitPullRequestRepo {
        return GitPullRequestRepoImpl(gitService)
    }
}