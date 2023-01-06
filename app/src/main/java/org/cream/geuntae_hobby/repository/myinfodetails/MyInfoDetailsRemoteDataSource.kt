package org.cream.geuntae_hobby.repository.myinfodetails

import org.cream.geuntae_hobby.model.MyInfoDetails
import org.cream.geuntae_hobby.network.ApiClient
import javax.inject.Inject

class MyInfoDetailsRemoteDataSource @Inject constructor(
    private val api: ApiClient
) : MyInfoDetailsDataSource {

    override suspend fun getMyInfoDetails(): List<MyInfoDetails> {
        return api.getMyInfoDetails()
    }
}