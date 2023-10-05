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
    lateinit var viewModelTest: MarsViewModel
    @get:Rule
    val testDispatcher = TestDispatcherRule()

    @Before
    fun setUp(){
        viewModelTest = MarsViewModel(FakeNetworkMarsPhotoRepository())
    }

    @Test
    fun `Verify the retrieval of marsPhotos is correctly executed and the uiState is updated`() = runTest {
        val expectedState: MarsUiState<String> = MarsUiState.Success(FakeDataSource.fakeMarsPhotos)
        val realState = viewModelTest.marsUiState
        assertEquals(expectedState, realState)
    }
}