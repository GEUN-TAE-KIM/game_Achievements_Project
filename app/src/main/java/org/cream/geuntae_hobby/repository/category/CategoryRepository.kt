package org.cream.geuntae_hobby.repository.category

import org.cream.geuntae_hobby.model.Category
import org.cream.geuntae_hobby.network.ApiClient
import javax.inject.Inject


class CategoryRepository @Inject constructor(
    private val remoteDataSource: CategoryRemoteDataSource
): CategoryRepositoryIn {

    // retrofit을 쓰기 떄문에 이렇게 지정할 필요가 없음
    /* withContext(Dispatchers.IO){
         remoteDataSource.getCategories()
     }*/

    override suspend fun getCategories(): List<Category> {
        return remoteDataSource.getCategories()
    }
}