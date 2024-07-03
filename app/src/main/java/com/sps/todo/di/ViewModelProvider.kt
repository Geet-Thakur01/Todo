package com.sps.todo.di

import com.sps.todo.domain.usecases.UseCases
import com.sps.todo.presentation.viewmodels.MainActivityViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent


@Module
@InstallIn(ActivityComponent::class)
object ViewModelProvider {

    @Provides
    fun getViewModelProvider(useCases: UseCases):MainActivityViewModel{
        return MainActivityViewModel(useCases)
    }
}