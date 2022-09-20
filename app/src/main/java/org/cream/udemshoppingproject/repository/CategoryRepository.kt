package org.cream.udemshoppingproject.repository


import org.cream.udemshoppingproject.model.Category

class CategoryRepository(private val remoteDataSource: CategoryRemoteDataSource) {

    suspend fun getCategories():List<Category> {

        // retrofit을 쓰기 떄문에 이렇게 지정할 필요가 없음
       /* withContext(Dispatchers.IO){
            remoteDataSource.getCategories()
        }*/
        return remoteDataSource.getCategories()
    }

}