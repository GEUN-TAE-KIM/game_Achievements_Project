package org.cream.udemshoppingproject.repository.home

import org.cream.udemshoppingproject.model.HomeData

class HomeRepository (private val assetDataSource: HomeAssetDataSource) {

    fun getHomeData(): HomeData? {
        return assetDataSource.getHomeData()
    }

}