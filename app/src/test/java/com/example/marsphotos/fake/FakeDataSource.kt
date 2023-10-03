package com.example.marsphotos.fake

import com.example.marsphotos.data.MarsPhoto

object FakeDataSource {
    const val idOne = "im1"
    const val idTwo = "im2"
    const val imgOne = "url.1"
    const val imgTwo = "url.2"
    val photosList = listOf<MarsPhoto>(
        MarsPhoto(idOne, imgOne),
        MarsPhoto(idTwo, imgTwo),
    )
}
