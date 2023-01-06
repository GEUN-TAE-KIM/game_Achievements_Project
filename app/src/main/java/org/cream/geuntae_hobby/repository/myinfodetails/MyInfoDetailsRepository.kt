package org.cream.geuntae_hobby.repository.myinfodetails

import org.cream.geuntae_hobby.model.MyInfoDetails
import javax.inject.Inject

class MyInfoDetailsRepository @Inject constructor(
    private val remoteDataSource: MyInfoDetailsRemoteDataSource
) : MyInfoDetailsRepositoryIn {
    override suspend fun getMyInfoDetails(): List<MyInfoDetails> {
        return remoteDataSource.getMyInfoDetails()
    }
}