package org.cream.udemshoppingproject

data class Banner(
    val backfroundImageUrl: String,
    val badge: BannerBadage,
    val label: String,
    val productDetail: ProductDetail
)

data class BannerBadage(
    val label: String,
    val backgroundColor: String
)

data class ProductDetail(
    val brandName: String,
    val label: String,
    val discountRate: Int,
    val price: Int,
    val thumbnail_image_url: String,
    val productId: String
)