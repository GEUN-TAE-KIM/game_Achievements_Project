package org.cream.udemshoppingproject.repository.categorydetail

import org.cream.udemshoppingproject.model.CategoryDetail

class CategoryDetailRepository (private val remoteDataSource: CategoryDetailRemoteDataSource) {
    suspend fun getCategoryDetail(): CategoryDetail{
        return remoteDataSource.getCategoryDetail()
    }
}

