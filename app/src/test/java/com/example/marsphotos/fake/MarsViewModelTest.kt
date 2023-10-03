package com.example.marsphotos.fake

import com.example.marsphotos.rules.TestDispatcherRule
import com.example.marsphotos.ui.screens.MarsUiState
import com.example.marsphotos.ui.screens.MarsViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class MarsViewModelTest {

    private lateinit var marsViewModel: MarsViewModel

    @get:Rule
    val testDispatcher = TestDispatcherRule()

    @Before
    fun setUp() {
        marsViewModel = MarsViewModel(FakeNetworkMarsPhotosRepository(FakeMarsApiService()))
    }

    @Test
    fun `When the MarsViewModel calls getMarsPhotos after instantiation, verify marsUiState is set to Success`() =
        runTest {
            assertEquals(
                MarsUiState.Success("Success: ${FakeDataSource.photosList.size} Mars photos retrieved"),
                marsViewModel.marsUiState
            )
        }
}
