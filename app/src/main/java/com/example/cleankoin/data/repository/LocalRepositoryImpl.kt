package com.example.cleankoin.data.repository

import com.example.cleankoin.model.User
import com.example.cleankoin.data.datasource.rest.api.LocalRepository
import io.reactivex.Single

class LocalRepositoryImpl() : LocalRepository {
    override fun getData(): Single<MutableList<User>> {
        val list:MutableList<User> = mutableListOf()
        list.add(User("Carlos Gabriel", "Ugaz Burga"))
        list.add(User("Wabu", "Uno"))
        list.add(User("Wabu", "Dos"))
        list.add(User("Wabu", "Tres"))
        list.add(User("Wabu", "Cuatro"))
        return Single.just(list)
    }
}