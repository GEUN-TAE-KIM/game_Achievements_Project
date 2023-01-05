package org.cream.geuntae_hobby.repository.categorydetail

import org.cream.geuntae_hobby.model.CategoryDetail
import org.cream.geuntae_hobby.network.ApiClient
import javax.inject.Inject
import javax.inject.Singleton

class CategoryDetailRemoteDataSource @Inject constructor(
    private val api: ApiClient
) : CategoryDetailDataSource {

    override suspend fun getCategoryDetail(categoryId: String): CategoryDetail {
        return api.getCategoryDetail(categoryId)
    }

   /*override suspend fun getCategoryDetail(): CategoryDetail {
       return api.getCategoryDetail()
   }*/

}