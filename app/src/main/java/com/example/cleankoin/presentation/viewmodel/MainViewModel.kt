package com.example.cleankoin.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleankoin.interactor.LocalInteractor
import com.example.cleankoin.presentation.viewmodel.viewstate.MainVS
import com.example.cleankoin.utils.Interactor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val repo : LocalInteractor) : ViewModel() {

    val disposables = CompositeDisposable()

    val state =  MutableLiveData<MainVS>()

    fun sayHello() {
        disposables.add(repo.execute(Interactor.None)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { MainVS.Loading}
            .subscribe({
                state.value = MainVS.GetData(it)
            },{
                state.value = MainVS.Error(it.toString())
            }))

    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }

}