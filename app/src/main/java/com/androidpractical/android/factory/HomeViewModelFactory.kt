package com.androidpractical.android.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.androidpractical.android.repository.HomeRepo
import com.androidpractical.android.server.ApiHelper
import com.androidpractical.android.viewmodel.HomeViewModel

class HomeViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(HomeRepo(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}