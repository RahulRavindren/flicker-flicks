package com.flickerflics.common.utils

import okhttp3.mockwebserver.MockWebServer

object Utils {

    fun mockServer(): MockWebServer {
        return MockWebServer()
    }

}