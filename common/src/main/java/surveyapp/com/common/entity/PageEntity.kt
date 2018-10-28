package surveyapp.com.common.entity

import android.net.Uri
import surveyapp.com.common.C

/**
 * @Author rahulravindran
 */

data class PageEntity(var page: Int,
                      var pageSize: Int,
                      var nextPageUrl: Uri,
                      var methodType: MethodType,
                      var query: String) {
    companion object {
        public val INITIAL = PageEntity(0, 10, Uri.EMPTY, MethodType.NON_QUERY, C.EMPTY_STRING)
    }

    fun increment() {
        page++;
    }

    fun decrement() {
        page--;
    }
}