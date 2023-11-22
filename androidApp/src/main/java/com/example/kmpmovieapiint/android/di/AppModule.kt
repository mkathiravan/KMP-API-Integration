package com.example.kmpmovieapiint.android.di

import com.example.kmpmovieapiint.android.feature.ui.viewModel.CatViewModel
import com.example.kmpmovieapiint.android.feature.ui.viewModel.PostViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        PostViewModel(get())
    }
    viewModel {
        CatViewModel(get())
    }
}