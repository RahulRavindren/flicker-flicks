package surveyapp.com.network.interceptor

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.mockwebserver.MockResponse
import org.junit.Assert
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import surveyapp.com.common.entity.AppCredentialPreference
import surveyapp.com.common.utils.PreferenceManager
import surveyapp.com.common.utils.Utils
import surveyapp.com.network.interceptors.ApplicationHeaderInterceptor

@RunWith(MockitoJUnitRunner::class)
class ApplicationHeaderInterceptorTest {

    private val server = Utils.mockServer()
    private val token = "adasddffhdufgutg973nkjnsfuhf989"

    private val pref = Mockito.mock(PreferenceManager::class.java)

    @Before
    fun setUp() {
        server.start()
        server.enqueue(MockResponse())
    }

    fun `test token as query param`() {
        val okHttpClient = OkHttpClient().newBuilder()
                .addInterceptor(ApplicationHeaderInterceptor()).build()
        okHttpClient.newCall(Request.Builder().url(server.url("/")).build()).execute()

        val requestRecord = server.takeRequest()
        Assert.assertEquals(null, requestRecord.getHeader("access_token"))
        server.shutdown()
    }

    fun `test token query param after saving in savedPref`() {
        val okHttpClient = OkHttpClient().newBuilder()
                .addInterceptor(ApplicationHeaderInterceptor()).build()
        pref.savePreference(AppCredentialPreference.ACCESS_TOKEN, token)
        okHttpClient.newCall(Request.Builder().url(server.url("/")).build()).execute()

        val requestRecord = server.takeRequest()
        Assert.assertEquals(token, requestRecord.getHeader("access_token"))

        server.shutdown()
    }

}