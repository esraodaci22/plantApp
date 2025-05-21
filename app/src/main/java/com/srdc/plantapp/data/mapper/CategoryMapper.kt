package com.srdc.plantapp.data.mapper

import com.srdc.plantapp.data.local.database.CategoryEntity
import com.srdc.plantapp.domain.model.Category

fun Category.toEntity(): CategoryEntity {
    return CategoryEntity(
        id = this.id,
        name = this.name,
        image = this.image
    )
}


fun CategoryEntity.toDomain(): Category {
    return Category(
        id = this.id,
        name = this.name,
        title = this.name,
        image = this.image,
    )
}
