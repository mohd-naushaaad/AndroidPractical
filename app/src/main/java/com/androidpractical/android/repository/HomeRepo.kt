package com.androidpractical.android.repository

import com.androidpractical.android.server.ApiHelper

class HomeRepo(private val apiHelper: ApiHelper) {

    suspend fun getRootData() = apiHelper.getRootData()
}