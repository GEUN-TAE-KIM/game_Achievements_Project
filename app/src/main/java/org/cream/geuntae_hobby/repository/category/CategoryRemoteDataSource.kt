package org.cream.geuntae_hobby.repository.category

import org.cream.geuntae_hobby.model.Category
import org.cream.geuntae_hobby.network.ApiClient

class CategoryRemoteDataSource(private val apiClient: ApiClient): CategoryDataSource {

    override suspend fun getCategories(): List<Category> {
        return apiClient.getCategories()
    }

}