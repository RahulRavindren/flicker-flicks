package com.flickerflics.common.utils

import com.flickerflics.common.C

/**
 * @Author rahulravindran
 */
class ApplicationUrlContainer {
    var baseUrl: String = C.EMPTY_STRING
        public get

    private constructor()
    private constructor(builder: AppConfigBuilder.Builder) {
        this.baseUrl = builder.baseUrl
    }

    companion object {

        private var INSTANCE: ApplicationUrlContainer? = null

        fun init(builder: AppConfigBuilder.Builder): ApplicationUrlContainer? {
            if (INSTANCE == null) {
                synchronized(ApplicationUrlContainer.javaClass) {
                    if (INSTANCE == null) {
                        INSTANCE = ApplicationUrlContainer(builder)
                    }
                }
            }
            return INSTANCE
        }

        public fun getInstance(): ApplicationUrlContainer? {
            if (INSTANCE == null) {
                synchronized(ApplicationUrlContainer.javaClass) {
                    if (INSTANCE == null) {
                        INSTANCE = ApplicationUrlContainer()
                    }
                }
            }
            return INSTANCE
        }
    }


}