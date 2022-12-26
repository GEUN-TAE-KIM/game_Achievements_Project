package org.cream.geuntae_hobby.repository.categorydetail

import org.cream.geuntae_hobby.model.CategoryDetail

interface CategoryDetailDataSource {

   // suspend fun getCategoryDetail(categoryId: String): CategoryDetail
    suspend fun getCategoryDetail(): CategoryDetail
    suspend fun getCategoryDetail2(): CategoryDetail

}