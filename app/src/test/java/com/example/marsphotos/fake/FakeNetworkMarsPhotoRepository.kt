package com.example.marsphotos.fake

import com.example.marsphotos.data.MarsPhoto
import com.example.marsphotos.data.MarsPhotosRepository

class FakeNetworkMarsPhotoRepository : MarsPhotosRepository {
    override suspend fun getMarsPhotos(): List<MarsPhoto> =
        FakeMarsApiService().getPhotos()
}
