package org.cream.geuntae_hobby.repository.home

import org.cream.geuntae_hobby.model.HomeData

interface HomeDataSource {

    fun getHomeData(): HomeData?
}