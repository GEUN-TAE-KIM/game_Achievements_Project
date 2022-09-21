package org.cream.udemshoppingproject.repository.category

import org.cream.udemshoppingproject.model.Category
import org.cream.udemshoppingproject.network.ApiClient
import org.cream.udemshoppingproject.repository.category.CategoryDataSource

class CategoryRemoteDataSource(private val apiClient: ApiClient): CategoryDataSource {

    override suspend fun getCategories(): List<Category> {
        return apiClient.getCategories()
    }

}