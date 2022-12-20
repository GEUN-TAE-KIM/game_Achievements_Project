package org.cream.geuntae_hobby.repository.home

import org.cream.geuntae_hobby.model.HomeData
import javax.inject.Inject
import javax.inject.Singleton


class HomeRepository (private val assetDataSource: HomeAssetDataSource) {

    fun getHomeData(): HomeData? {
        return assetDataSource.getHomeData()
    }

}