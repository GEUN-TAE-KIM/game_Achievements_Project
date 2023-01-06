package org.cream.geuntae_hobby.repository.myinfodetails

import org.cream.geuntae_hobby.model.MyInfoDetails

interface MyInfoDetailsRepositoryIn {

    suspend fun getMyInfoDetails(): List<MyInfoDetails>
}