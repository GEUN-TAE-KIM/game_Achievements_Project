package org.cream.udemshoppingproject.repository.home

import org.cream.udemshoppingproject.model.HomeData

interface HomeDataSource {

    fun getHomeData(): HomeData?
}