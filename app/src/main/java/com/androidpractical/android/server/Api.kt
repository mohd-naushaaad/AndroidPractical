package com.androidpractical.android.server

import com.androidpractical.android.model.RootModel
import retrofit2.http.GET

interface Api {

    @GET(Urls.COIN_LIST)
    suspend fun getRootData(): RootModel
}