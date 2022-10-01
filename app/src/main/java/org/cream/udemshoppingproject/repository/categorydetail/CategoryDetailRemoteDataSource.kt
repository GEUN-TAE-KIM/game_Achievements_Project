package org.cream.udemshoppingproject.repository.categorydetail

import org.cream.udemshoppingproject.model.CategoryDetail
import org.cream.udemshoppingproject.network.ApiClient

class CategoryDetailRemoteDataSource(private val api: ApiClient): CategoryDetailDataSource {
    override suspend fun getCategoryDetail(): CategoryDetail {
        return api.getCategoryDetail()
    }
}