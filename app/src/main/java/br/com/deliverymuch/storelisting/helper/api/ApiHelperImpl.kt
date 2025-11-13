package br.com.deliverymuch.storelisting.helper.api

import kotlinx.serialization.ExperimentalSerializationApi

@OptIn(ExperimentalSerializationApi::class)
object ApiHelperImpl : ApiHelper {
    override fun parseErrorBody(throwable: Throwable): ApiError? {
        if (throwable is ApiError) {
            return throwable
        }
        if (throwable is retrofit2.HttpException) {
            val body = throwable.response()?.errorBody()
            return ApiError()
        }
        return null
    }
}