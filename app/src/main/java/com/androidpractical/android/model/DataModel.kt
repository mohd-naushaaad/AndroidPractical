package com.androidpractical.android.model

import com.google.gson.annotations.SerializedName

data class DataModel(

    @SerializedName("totalItems")
    var totalItems: Int? = null,

    @SerializedName("startIndex")
    val startIndex: Int? = null,

    @SerializedName("itemsPerPage")
    val itemsPerPage: Int? = null,

    @SerializedName("list")
    val listModels: ArrayList<ListModel> = ArrayList()
)
