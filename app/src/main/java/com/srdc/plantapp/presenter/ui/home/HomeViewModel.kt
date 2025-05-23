package com.srdc.plantapp.presenter.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.srdc.plantapp.data.local.database.CategoryEntity
import com.srdc.plantapp.data.remote.repository.CategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: CategoryRepository
) : ViewModel() {

    private val _categories = MutableStateFlow<List<CategoryEntity>>(emptyList())
    val categories: StateFlow<List<CategoryEntity>> = _categories.asStateFlow()

    init {
        viewModelScope.launch {
            repository.fetchAndCacheCategories()
        }

        viewModelScope.launch {
            repository.getCategories().collect {
                _categories.value = it.map { category ->
                    CategoryEntity(
                        id = category.id,
                        name = category.name,
                        image = category.image
                    )
                }
            }
        }
    }
}

