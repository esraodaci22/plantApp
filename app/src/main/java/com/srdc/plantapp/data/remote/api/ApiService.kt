package com.srdc.plantapp.data.remote.api

import com.srdc.plantapp.data.remote.model.CategoryResponse
import retrofit2.http.GET

interface ApiService {
    @GET("getCategories")
    suspend fun getCategories(): CategoryResponse
}
