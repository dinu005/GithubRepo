package com.navi.githubrepo.di

import com.navi.githubrepo.network.GitRepoApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

import retrofit2.Retrofit

@Module
@InstallIn(ActivityComponent::class)
object GitRepoModule {

    @Provides
    fun providesGitRepoApi(retrofit: Retrofit): GitRepoApi {
        return retrofit.create(GitRepoApi::class.java)
    }
}