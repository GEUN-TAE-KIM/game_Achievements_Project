package org.cream.geuntae_hobby.model

import com.google.gson.annotations.SerializedName

data class MyInfoDetails(
    @SerializedName("category_id") val categoryId: String,
    val label: String,
    val label1: String,
    val label2: String,
    @SerializedName("thumbnail_image_url") val thumbnailImageUrl: String,
    val updated: Boolean
)
