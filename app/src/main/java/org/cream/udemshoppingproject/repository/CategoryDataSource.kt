package org.cream.udemshoppingproject.repository

import org.cream.udemshoppingproject.model.Category

interface CategoryDataSource {

    suspend fun getCategories(): List<Category>
}