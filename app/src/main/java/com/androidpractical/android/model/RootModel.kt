package com.androidpractical.android.model

import com.google.gson.annotations.SerializedName

data class RootModel(

    @SerializedName("result")
    var result: Int? = null,

    @SerializedName("msg")
    var message: String? = null,

    @SerializedName("data")
    var dataModel: DataModel? = null
)
