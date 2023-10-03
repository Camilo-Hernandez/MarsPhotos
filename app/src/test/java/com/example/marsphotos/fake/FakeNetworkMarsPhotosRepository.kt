package com.example.marsphotos.fake

import com.example.marsphotos.data.MarsPhoto
import com.example.marsphotos.data.MarsPhotosRepository

class FakeNetworkMarsPhotosRepository(private val fakeMarsApiService: FakeMarsApiService) : MarsPhotosRepository {
    override suspend fun getMarsPhotos(): List<MarsPhoto> = fakeMarsApiService.getPhotos()
}
