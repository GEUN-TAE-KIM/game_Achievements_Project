package org.cream.geuntae_hobby.repository.category

import org.cream.geuntae_hobby.model.Category
import org.cream.geuntae_hobby.network.ApiClient
import javax.inject.Inject

class CategoryRemoteDataSource @Inject constructor(
    private val api: ApiClient
) : CategoryDataSource {

    override suspend fun getCategories(): List<Category> {
        return api.getCategories()
    }

}