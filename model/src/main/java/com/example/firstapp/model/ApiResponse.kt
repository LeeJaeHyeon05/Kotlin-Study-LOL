package com.example.firstapp.model

/**
 * @author hanago
 * @email kottodat@naver.com
 * @since 2021/11/13
 **/
sealed class ApiResponse<out T> {
    data class Success<T>(val value: T) : ApiResponse<T>()
    object Loading : ApiResponse<Nothing>()
    data class Failure(val e: Throwable) : ApiResponse<Nothing>()
}