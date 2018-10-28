package surveyapp.com.common.utils

import android.app.Application
import android.content.Intent
import com.google.gson.Gson
import java.io.File

/**
 * @Author rahulravindran
 */
class Utils {
    companion object {
        var application: Application? = null
            set(value) {
                field = value
            }
            get() = field

        val GSON: Gson = Gson()
        var debug: Boolean = true


        public fun startActivity(intent: Intent) {
            application?.startActivity(intent)
        }


        public fun getDeviceHeight(): Int {
            return application!!.resources.displayMetrics.heightPixels
        }

        public fun getDeviceWidth(): Int {
            return application!!.resources.displayMetrics.widthPixels
        }


        public fun getCacheDir(dirname: String): File {
            val cacheDir = application?.filesDir
            val httpCacheDir = File(cacheDir, dirname)
            if (httpCacheDir != null) {
                httpCacheDir.mkdirs()
            }
            return httpCacheDir
        }

        public fun getString(id: Int): String? {
            return application?.getString(id)
        }

        fun getStringParams(id: Int, vararg values: String): String? {
            return application?.getString(id, values)
        }


    }

    data class Event(val message: String?, val throwable: Throwable)
}