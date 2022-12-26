package org.cream.geuntae_hobby.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

sealed class MyInfo
data class MyInfoHeader(
    val brandName: String
): MyInfo()

@Entity(
    tableName = "cart_item"
)
data class MyInfoItem(
    @PrimaryKey @ColumnInfo(name = "product_id") val productId: String,
    val label: String,
    val price: Int,
    @ColumnInfo(name = "brand_name") val brandName: String,
    @ColumnInfo(name = "thumbnail_image_url") val thumbnailImageUrl: String,
    val type: String,
    val amount: Int
): MyInfo()