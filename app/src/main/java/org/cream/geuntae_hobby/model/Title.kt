package org.cream.geuntae_hobby.model

import com.google.gson.annotations.SerializedName

data class Title(
    val text: String,
    @SerializedName("icon_url") val iconUrl: String?
)
