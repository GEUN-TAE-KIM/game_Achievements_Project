package org.cream.udemshoppingproject.repository.category

import org.cream.udemshoppingproject.model.Category

interface CategoryDataSource {

    suspend fun getCategories(): List<Category>
}