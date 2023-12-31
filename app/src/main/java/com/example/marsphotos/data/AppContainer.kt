package com.example.marsphotos.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val marsPhotosRepository: MarsPhotosRepository
}

class DefaultAppContainer() : AppContainer{
    override val marsPhotosRepository: MarsPhotosRepository by lazy {
        NetworkMarsPhotosRepository(service)
    }

    private val baseUrl =
        "https://android-kotlin-fun-mars-server.appspot.com/"

    private val retrofitObject: Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    internal val service: MarsApiService by lazy {
        retrofitObject.create(MarsApiService::class.java)
    }

}