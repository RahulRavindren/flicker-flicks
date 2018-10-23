package surveyapp.com.network.interceptors

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import surveyapp.com.network.utils.AccessTokenWrapper
import surveyapp.com.network.utils.NetworkUtils

/**
 * @Author rahulravindran
 */
class ApplicationHeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain?): Response {
        if (!NetworkUtils.isNetworkConnected()) {
            return chain!!.proceed(chain.request())
        }
        val request: Request = chain!!.request()
        val accessToken = AccessTokenWrapper().getAccessToken()
        val newRequestUrl = request.url().newBuilder()
        if (accessToken != null) {
            newRequestUrl.addQueryParameter("access_token", accessToken.accessToken)
        }
        return chain.proceed(request.newBuilder().url(newRequestUrl.build()).build())
    }
}