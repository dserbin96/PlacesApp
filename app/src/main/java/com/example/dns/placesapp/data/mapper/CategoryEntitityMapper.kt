package com.example.dns.placesapp.data.mapper

import com.example.dns.placesapp.data.model.CategoryDTO
import com.example.dns.placesapp.domain.global.entity.CategoryEntity
import javax.inject.Inject

class CategoryEntitityMapper @Inject constructor() {

    fun mapToCategoryEntity(categoryDTO: CategoryDTO): CategoryEntity {
        return CategoryEntity(categoryDTO.categoryId,
                categoryDTO.name,
                categoryDTO.icon.prefix + categoryDTO.icon.suffix)
    }

}