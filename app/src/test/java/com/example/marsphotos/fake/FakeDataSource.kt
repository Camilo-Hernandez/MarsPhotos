package com.example.marsphotos.fake

import com.example.marsphotos.data.MarsPhoto

object FakeDataSource {
    private const val id1 = "id1"
    private const val url1 = "url1"

    private const val id2 = "id2"
    private const val url2 = "url2"

    val fakeMarsPhotos = listOf(
        MarsPhoto(id1, url1),
        MarsPhoto(id2, url2),
    )
}
