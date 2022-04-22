package com.androidpractical.android.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.androidpractical.android.model.ListModel
import com.androidpractical.android.repository.HomeRepo
import com.androidpractical.android.server.Resource
import kotlinx.coroutines.Dispatchers

class HomeViewModel(private val homeRepo: HomeRepo) : ViewModel() {

    var mList: ArrayList<ListModel> = ArrayList()

    fun getRootData() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = homeRepo.getRootData()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}