package surveyapp.com.network.interceptors

import okhttp3.Interceptor
import okhttp3.Response
import surveyapp.com.common.utils.Utils
import surveyapp.com.network.R
import surveyapp.com.network.exceptions.NetworkConnectivityException
import surveyapp.com.network.utils.NetworkUtils

/**
 * @Author rahulravindran
 */
class NetworkConnectivityInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain?): Response {
        if (!NetworkUtils.isNetworkConnected()) {
            val exception = NetworkConnectivityException(Utils.getString(R.string.no_network_msg))
        }
        return chain!!.proceed(chain.request())
    }
}