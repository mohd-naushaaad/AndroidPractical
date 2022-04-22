package com.androidpractical.android.server

class ApiHelper(private val api: Api) {

    suspend fun getRootData() = api.getRootData()
}