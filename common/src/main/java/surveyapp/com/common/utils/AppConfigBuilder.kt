package surveyapp.com.common.utils

import surveyapp.com.common.C

/**
 * @Author rahulravindran
 */
class AppConfigBuilder {
    var env: String = C.EMPTY_STRING
    var applicationId: String = C.EMPTY_STRING
        private set
    var applicationVersion: String = C.EMPTY_STRING
        private set
    var applicationCode: Int = -1
        private set

    private constructor()

    private constructor(builder: Builder) {
        this.env = builder.env
        ApplicationUrlContainer.init(builder)
    }


    companion object {
        private var INSTANCE: AppConfigBuilder? = null
        public fun getInstance(): AppConfigBuilder? {
            return INSTANCE
        }

        private fun getInstance(builder: Builder): AppConfigBuilder? {
            if (INSTANCE == null) {
                synchronized(AppConfigBuilder::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = AppConfigBuilder(builder)
                    }
                }
            }
            return INSTANCE
        }
    }


    class Builder() {
        lateinit var baseUrl: String
        lateinit var env: String
        lateinit var applicationId: String
        lateinit var applicationVersion: String
        var applicationCode: Int = -1

        fun setApplicationUrl(url: String): Builder {
            baseUrl = url
            return this
        }

        fun setApplicationEnv(env: String): Builder {
            this.env = env;
            return this
        }

        fun setApplicationID(id: String): Builder {
            this.applicationId = id
            return this
        }

        fun setApplicationVersion(version: String): Builder {
            this.applicationVersion = version
            return this
        }

        fun setApplicationCode(code: Int): Builder {
            this.applicationCode = code
            return this
        }


        fun build() {
            getInstance(this)
        }
    }
}