package org.cream.udemshoppingproject

import com.google.gson.annotations.SerializedName

data class HomData(
    // gson 라이브러리에서는 프로퍼티랑 json 오브젝트 명이 같아야함 제약조건임
    val title: Title,

    // 上에 있는 제약조건을 무시하는 것
    @SerializedName("top_banner") val topBanners: List<Banner>

)
