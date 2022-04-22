package com.androidpractical.android.model

import com.google.gson.annotations.SerializedName

data class PictureModel(

    @SerializedName("front")
    var frontModel: FrontModel? = null,

    @SerializedName("back")
    val backModel: BackModel? = null
)