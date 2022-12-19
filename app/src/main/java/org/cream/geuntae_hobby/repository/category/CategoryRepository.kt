package org.cream.geuntae_hobby.repository.category

import org.cream.geuntae_hobby.model.Category
import javax.inject.Inject
import javax.inject.Singleton


class CategoryRepository (private val remoteDataSource: CategoryRemoteDataSource) {

    suspend fun getCategories():List<Category> {

        // retrofit을 쓰기 떄문에 이렇게 지정할 필요가 없음
       /* withContext(Dispatchers.IO){
            remoteDataSource.getCategories()
        }*/
        return remoteDataSource.getCategories()
    }

}