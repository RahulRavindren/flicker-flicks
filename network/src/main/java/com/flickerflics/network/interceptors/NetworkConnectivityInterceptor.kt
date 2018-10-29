package com.flickerflics.network.interceptors

import com.flickerflics.network.exceptions.NetworkConnectivityException
import com.flickerflics.network.utils.NetworkUtils
import okhttp3.Interceptor
import okhttp3.Response

/**
 * @Author rahulravindran
 */
class NetworkConnectivityInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain?): Response {
        if (!NetworkUtils.isNetworkConnected()) {
            throw NetworkConnectivityException()
        }
        return chain!!.proceed(chain.request())
    }


}
