package org.cream.udemshoppingproject.repository.home

import com.google.gson.Gson
import org.cream.udemshoppingproject.model.HomeData
import org.cream.udemshoppingproject.assets.AssetLoder


class HomeAssetDataSource(private val assetLoder: AssetLoder ) : HomeDataSource {

    private val gson = Gson()

    override fun getHomeData(): HomeData? {

        return  assetLoder.getJsonString("home,json")?.let { homeJsonString ->
            gson.fromJson(homeJsonString, HomeData::class.java)
        }


    }
}