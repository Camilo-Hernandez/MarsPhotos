package com.example.marsphotos.data

import retrofit2.http.GET

fun interface MarsApiService {

    @GET("photos")
    suspend fun getPhotos(): List<MarsPhoto>
}