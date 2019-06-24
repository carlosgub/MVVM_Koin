package com.example.cleankoin.data.datasource.rest.api

import com.example.cleankoin.model.User
import io.reactivex.Single

interface LocalRepository {
    fun getData(): Single<MutableList<User>>
}