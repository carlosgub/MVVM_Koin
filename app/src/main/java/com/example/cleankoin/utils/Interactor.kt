package com.example.cleankoin.utils

interface Interactor<in Params, out Type> {

    fun execute(params: Params): Type

    /***
     * Use this class for non value Params
     */
    object None

    // TODO: Add Params restriction
}