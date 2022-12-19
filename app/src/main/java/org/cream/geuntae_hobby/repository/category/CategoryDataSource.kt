package org.cream.geuntae_hobby.repository.category

import org.cream.geuntae_hobby.model.Category

interface CategoryDataSource {

    suspend fun getCategories(): List<Category>
}