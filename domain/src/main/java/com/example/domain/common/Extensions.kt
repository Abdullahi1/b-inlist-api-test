package com.example.domain.common

import java.util.*

fun <T> tryCatch(action: () -> T): Result<T> =
    try {
        Result.success(action())
    } catch (e: Exception) {
        Result.error(message = e.message ?: "An error occurred")
    }

fun <T> tryCatchWithoutResource(action: () -> T): T? =
    try {
        action()
    } catch (e: Exception) {
        null
    }

suspend fun <T> tryCatchSuspend(action: suspend () -> T): Result<T> =
    try {
        Result.success(action())
    } catch (e: Exception) {
        Result.error(message = e.message ?: "An error occurred")
    }

fun generateId(): String = UUID.randomUUID().toString()