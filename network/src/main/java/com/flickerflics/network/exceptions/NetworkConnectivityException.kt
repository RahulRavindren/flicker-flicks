package com.flickerflics.network.exceptions

import java.io.IOException

/**
 * @Author rahulravindran
 */
class NetworkConnectivityException : IOException {
    constructor() : super()
    constructor(message: String?) : super(message)
    constructor(message: String?, cause: Throwable?) : super(message, cause)
    constructor(cause: Throwable?) : super(cause)
}