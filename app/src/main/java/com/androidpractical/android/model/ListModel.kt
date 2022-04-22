package com.androidpractical.android.model

import com.google.gson.annotations.SerializedName
import kotlin.collections.List

data class ListModel(
    @SerializedName("_id")
    var id: String? = null,

    @SerializedName("price")
    val price: Int? = null,

    @SerializedName("age")
    val age: Int? = null,

    @SerializedName("isGraded")
    val isGraded: Boolean? = null,

    @SerializedName("isSold")
    val isSold: Boolean? = null,

    @SerializedName("isCoin")
    val isCoin: Boolean? = null,

    @SerializedName("tags")
    val tags: ArrayList<String> = ArrayList(),

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("history")
    val history: String? = null,

    @SerializedName("year")
    val year: Int? = null,

    @SerializedName("pictures")
    val pictureModel: PictureModel? = null
)