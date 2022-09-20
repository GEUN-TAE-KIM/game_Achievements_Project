package org.cream.udemshoppingproject.repository

import org.cream.udemshoppingproject.model.Category
import org.cream.udemshoppingproject.network.ApiClient

class CategoryRemoteDataSource(private val apiClient: ApiClient): CategoryDataSource {

    override suspend fun getCategories(): List<Category> {
        return apiClient.getCategories()
    }

}