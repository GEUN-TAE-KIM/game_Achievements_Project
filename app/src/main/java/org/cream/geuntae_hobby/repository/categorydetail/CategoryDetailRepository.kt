package org.cream.geuntae_hobby.repository.categorydetail

import org.cream.geuntae_hobby.model.CategoryDetail
import javax.inject.Inject
import javax.inject.Singleton


class CategoryDetailRepository (private val remoteDataSource: CategoryDetailRemoteDataSource) {
    suspend fun getCategoryDetail(): CategoryDetail{
        return remoteDataSource.getCategoryDetail()
    }
}

