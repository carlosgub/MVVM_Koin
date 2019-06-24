package com.example.cleankoin.presentation.viewmodel.viewstate

import com.example.cleankoin.model.User

sealed class MainVS {
    object Loading : MainVS()
    class Error(val reason: String) : MainVS()
    class GetData(val mutableList: MutableList<User>) : MainVS()
}