package org.cream.geuntae_hobby.repository.categorydetail

import org.cream.geuntae_hobby.model.CategoryDetail
import javax.inject.Inject

class CategoryDetailRepository @Inject constructor(
    private val remoteDataSource: CategoryDetailRemoteDataSource
) : CategoryDetailDataSource {

    override suspend fun getCategoryDetail(categoryId: String): CategoryDetail {
        return remoteDataSource.getCategoryDetail(categoryId)
    }

    /*override suspend fun getCategoryDetail(): CategoryDetail {
        return remoteDataSource.getCategoryDetail()
    }*/


}

