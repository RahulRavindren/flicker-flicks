package surveyapp.com.common.entity

/**
 * @Author rahulravindran
 */

data class PageEntity(var page: Int, var pageSize: Int) {
    companion object {
        public val INITIAL = PageEntity(0, 10)
    }
}