package com.example.marsphotos.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

fun interface MarsApiService {

    @GET("photos")
    suspend fun getPhotos(): List<MarsPhoto>

    companion object {
        private const val BASE_URL =
            "https://android-kotlin-fun-mars-server.appspot.com/"

        private val retrofitObject: Retrofit = Retrofit.Builder()
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .baseUrl(BASE_URL)
            .build()

        internal val service: MarsApiService by lazy {
            retrofitObject.create(MarsApiService::class.java)
        }
    }
}