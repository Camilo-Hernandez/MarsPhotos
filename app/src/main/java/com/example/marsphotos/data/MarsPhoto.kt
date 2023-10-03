package com.example.marsphotos.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MarsPhoto(
    @SerialName("id") val id: String,
    @SerialName("img_src") val imgSrc: String,
)
