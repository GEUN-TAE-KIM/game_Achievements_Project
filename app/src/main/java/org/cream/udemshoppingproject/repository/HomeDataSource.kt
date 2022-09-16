package org.cream.udemshoppingproject.repository

import org.cream.udemshoppingproject.model.HomeData

interface HomeDataSource {

    fun getHomeData(): HomeData?
}