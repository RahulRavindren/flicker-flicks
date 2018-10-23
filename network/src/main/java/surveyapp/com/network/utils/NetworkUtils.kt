package surveyapp.com.network.utils

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import surveyapp.com.common.utils.Utils

/**
 * @Author rahulravindran
 */
object NetworkUtils {
    @SuppressLint("MissingPermission")
    fun isNetworkConnected(): Boolean {
        val connectionManager = Utils.application?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectionManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }
}