package com.example.domain.common


/**
 * A generic class that holds data and status.
 */
data class Result<out T>(
    val status: Status,
    val data: T?,
    val message: String
) {
    companion object {

        fun <T> success(data: T?): Result<T> {
            return Result(Status.SUCCESS, data, "")
        }

        fun <T> error(message: String, data: T? = null): Result<T> {
            return Result(Status.ERROR, data, message)
        }

        fun <T> loading(data: T? = null): Result<T> {
            return Result(Status.LOADING, data, "")
        }
    }

    fun isSuccess(): Boolean =
        status == Status.SUCCESS

    fun isLoading(): Boolean =
        status == Status.LOADING

    fun isError(): Boolean =
        status == Status.ERROR
}

enum class Status {

    SUCCESS,

    ERROR,

    LOADING
}