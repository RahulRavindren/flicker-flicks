package com.flickerflics.network.utils

import com.flickerflics.network.exceptions.BaseError

/**
 * @Author rahulravindran
 */
interface CallbackState<T> {
    fun onSuccess(value: T)
    fun onError(error: BaseError)
}