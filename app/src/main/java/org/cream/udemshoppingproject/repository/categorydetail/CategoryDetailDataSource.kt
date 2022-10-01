package org.cream.udemshoppingproject.repository.categorydetail

import org.cream.udemshoppingproject.model.CategoryDetail

interface CategoryDetailDataSource {

    suspend fun getCategoryDetail(): CategoryDetail

}