package com.okawa.sample.googlemaps.data.livedata

enum class DataState { LOADING, SUCCESS, ERROR }

data class Data<T> constructor(val dataState: DataState, val data: T? = null, val message: String? = null)

fun <T> dataSuccess(data: T): Data<T> = Data(DataState.SUCCESS, data)
fun <T> dataLoading(data: T? = null): Data<T> = Data(DataState.LOADING, data)
fun <T> dataError(message: String?, data: T? = null): Data<T> = Data(DataState.ERROR, data, message)