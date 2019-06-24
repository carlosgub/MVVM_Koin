package com.example.cleankoin.interactor

import com.example.cleankoin.data.datasource.rest.api.LocalRepository
import com.example.cleankoin.model.User
import com.example.cleankoin.utils.Interactor
import io.reactivex.Single

class LocalInteractor (private val localRepository: LocalRepository)
    : Interactor<Interactor.None,Single<MutableList<User>>> {

    override fun execute(params: Interactor.None): Single<MutableList<User>> {
        return localRepository.getData()
    }
}