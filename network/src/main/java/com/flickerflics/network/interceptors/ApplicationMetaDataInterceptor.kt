package com.flickerflics.network.interceptors

import com.flickerflics.common.C
import com.flickerflics.common.utils.AppConfigBuilder
import okhttp3.Interceptor
import okhttp3.Response

/**
 * @Author rahulravindran
 */
class ApplicationMetaDataInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain?): Response {
        val request = chain?.request()
        val requestBuilder = request!!.newBuilder()
                .addHeader(C.APPLICATION_VERSION_NAME, AppConfigBuilder.getInstance()?.applicationVersion)
                .addHeader(C.APPLICATION_ID, AppConfigBuilder.getInstance()?.applicationId)
                .addHeader(C.APPLICATION_VERISON_CODE, AppConfigBuilder.getInstance()?.applicationCode.toString())
        return chain.proceed(requestBuilder.build())
    }
}