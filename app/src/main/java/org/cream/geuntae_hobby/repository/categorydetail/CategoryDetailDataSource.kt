package org.cream.geuntae_hobby.repository.categorydetail

import org.cream.geuntae_hobby.model.CategoryDetail

interface CategoryDetailDataSource {

    suspend fun getCategoryDetail(): CategoryDetail

}