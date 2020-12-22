package com.example.data.common

import com.example.domain.common.Result
import retrofit2.HttpException
import timber.log.Timber

/**
 * Handle and log exceptions
 */
suspend fun <T> sendRequest(action: suspend () -> T): Result<T> {
    try {
        return Result.success(action())
    } catch (e: Exception) {
        Timber.e(e)
        if (e is HttpException) {
            if (e.code() == 404) {
                return Result.error("Request Not found")
            }
            return Result.error("Connection error. Try again")
        }
        return Result.error("Connection error. Try again")
    }
}