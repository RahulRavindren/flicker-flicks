package com.flickerflics.network.interceptors

import com.flickerflics.common.utils.AppConfigBuilder
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

/**
 * @Author rahulravindran
 */
class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain?): Response {
        val request: Request = chain!!.request()
        val apiKey = AppConfigBuilder.getInstance()?.apiKey
        val newRequestUrl = request.url().newBuilder()
        if (apiKey != null) {
            newRequestUrl.addQueryParameter("api_key", apiKey)
        }
        return chain.proceed(request.newBuilder().url(newRequestUrl.build()).build())
    }
}