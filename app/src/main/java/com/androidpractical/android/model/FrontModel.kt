package com.androidpractical.android.model

import com.google.gson.annotations.SerializedName

data class FrontModel(

    @SerializedName("key")
    var key: String? = null,

    @SerializedName("url")
    val url: String? = null,

    @SerializedName("sizeInMegaByte")
    val sizeInMegaByte: Double? = null
)