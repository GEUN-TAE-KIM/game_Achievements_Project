package org.cream.geuntae_hobby.repository.categorydetail

import org.cream.geuntae_hobby.model.CategoryDetail
import org.cream.geuntae_hobby.network.ApiClient

class CategoryDetailRemoteDataSource(private val api: ApiClient): CategoryDetailDataSource {
    override suspend fun getCategoryDetail(): CategoryDetail {
        return api.getCategoryDetail()
    }
}