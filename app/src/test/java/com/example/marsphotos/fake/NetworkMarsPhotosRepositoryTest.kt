package com.example.marsphotos.fake

import com.example.marsphotos.data.NetworkMarsPhotosRepository
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class NetworkMarsPhotosRepositoryTest {

    @Test
    fun `When getMarsPhotos is called, verify photos list`() = runTest {
        val repository = NetworkMarsPhotosRepository(FakeMarsApiService())
        assertEquals(FakeDataSource.photosList, repository.getMarsPhotos())
    }
}
