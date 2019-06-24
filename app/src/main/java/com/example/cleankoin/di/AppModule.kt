package com.example.cleankoin.di

import com.example.cleankoin.data.datasource.rest.api.LocalRepository
import com.example.cleankoin.data.repository.LocalRepositoryImpl
import com.example.cleankoin.interactor.LocalInteractor
import com.example.cleankoin.presentation.viewmodel.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dataModule = module {
    single<LocalRepository> { LocalRepositoryImpl() }
}

val interactor = module {
    factory { LocalInteractor(get()) }
}

val viewModule = module {
    viewModel { MainViewModel(get()) }
}