package org.cream.geuntae_hobby.model

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("brand_name") val brandName: String?,
    val label: String,
    val type: String?,
    @SerializedName("thumbnail_image_url") val thumbnailImageUrl: String?,
    @SerializedName("representative_image_url") val representativeImageUrl: String?,
    val descriptions: List<Description>?,
    @SerializedName("product_id") val productId: String
)

data class Description(
    val id: String,
    val detail: String,
)