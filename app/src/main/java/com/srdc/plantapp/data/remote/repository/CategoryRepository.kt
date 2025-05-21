package com.srdc.plantapp.data.remote.repository

import com.srdc.plantapp.data.local.dao.CategoryDao
import com.srdc.plantapp.data.local.database.CategoryEntity
import com.srdc.plantapp.data.mapper.toEntity
import com.srdc.plantapp.data.remote.api.ApiService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CategoryRepository @Inject constructor(
    private val apiService: ApiService,
    private val categoryDao: CategoryDao
) {
    fun getCategories(): Flow<List<CategoryEntity>> {
        return categoryDao.getAllCategories()
    }

    suspend fun fetchAndCacheCategories() {
        val response = apiService.getCategories()
        val entities = response.data.map { it.toEntity() }
        categoryDao.insertAll(entities)
    }

    suspend fun clearCategories() {
        categoryDao.clearAll()
    }
}
