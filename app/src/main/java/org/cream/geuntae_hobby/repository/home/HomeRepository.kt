package org.cream.geuntae_hobby.repository.home

import org.cream.geuntae_hobby.model.HomeData

class HomeRepository (private val assetDataSource: HomeAssetDataSource) {

    fun getHomeData(): HomeData? {
        return assetDataSource.getHomeData()
    }

}