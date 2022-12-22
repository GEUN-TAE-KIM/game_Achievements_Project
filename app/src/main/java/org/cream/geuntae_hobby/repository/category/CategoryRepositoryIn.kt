package org.cream.geuntae_hobby.repository.category

import org.cream.geuntae_hobby.model.Category

interface CategoryRepositoryIn {
    suspend fun getCategories(): List<Category>

}