package com.example.marsphotos.fake

import com.example.marsphotos.data.MarsPhoto
import com.example.marsphotos.data.MarsPhotosRepository
import com.example.marsphotos.data.NetworkMarsPhotosRepository
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class NetworkMarsPhotosRepositoryTest {

    lateinit var fakeMarsPhotosRepository: MarsPhotosRepository
    @Before
    fun setUp() {
        fakeMarsPhotosRepository = NetworkMarsPhotosRepository(
            service = FakeMarsApiService()
        )
    }

    @Test
    fun `When calling the mars photos service, if successful, the service returns a List of MarsPhotos`() = runTest {
        val expectedResult: List<MarsPhoto> = FakeDataSource.fakeMarsPhotos
        assertEquals(expectedResult, fakeMarsPhotosRepository.getMarsPhotos())
    }
}