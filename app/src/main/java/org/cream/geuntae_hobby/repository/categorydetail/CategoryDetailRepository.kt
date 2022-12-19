package org.cream.geuntae_hobby.repository.categorydetail

import org.cream.geuntae_hobby.model.CategoryDetail

class CategoryDetailRepository (private val remoteDataSource: CategoryDetailRemoteDataSource) {
    suspend fun getCategoryDetail(): CategoryDetail{
        return remoteDataSource.getCategoryDetail()
    }
}

