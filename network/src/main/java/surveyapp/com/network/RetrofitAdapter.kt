package surveyapp.com.network

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import surveyapp.com.common.utils.ApplicationUrlContainer
import surveyapp.com.network.interceptors.ApplicationMetaDataInterceptor
import surveyapp.com.network.interceptors.NetworkConnectivityInterceptor
import java.util.concurrent.TimeUnit

/**
 * @Author rahulravindran
 */

const val READ_TIME_OUT = 60000L
const val WRITE_TIME_OUT = 60000L

class RetrofitAdapter {

    private companion object {


        fun retrofitClient(baseHost: HttpUrl, interceptors: Collection<Interceptor>?): Retrofit {
            return Retrofit.Builder()
                    .baseUrl(baseHost)
                    .client(getClient(interceptors))
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }

        public fun retrofitClient(interceptors: Collection<Interceptor>?): Retrofit {
            if (ApplicationUrlContainer.getInstance()!!.baseUrl.isEmpty()) {
                throw NullPointerException("base URL empty")
            }

            return retrofitClient(HttpUrl.Builder()
                    .scheme("https")
                    .host(ApplicationUrlContainer.getInstance()?.baseUrl).build(), interceptors)
        }

        private fun getClient(interceptors: Collection<Interceptor>?): OkHttpClient {
            var clientBuilder = OkHttpClient.Builder()
                    .addInterceptor(NetworkConnectivityInterceptor())
                    .addInterceptor(ApplicationMetaDataInterceptor())
                    .readTimeout(READ_TIME_OUT, TimeUnit.MILLISECONDS)
                    .writeTimeout(WRITE_TIME_OUT, TimeUnit.MILLISECONDS)

            if (BuildConfig.DEBUG) {
                clientBuilder.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))

            }

            interceptors?.forEach { interceptor: Interceptor -> clientBuilder.addInterceptor(interceptor) }
            return clientBuilder.build()
        }
    }


    class Factory {

        companion object {
            public fun <T : Any?> getRestService(service: Class<T>, interceptors: Collection<Interceptor>?): T {
                return retrofitClient(interceptors).create(service)
            }

            public fun <T : Any?> getRestService(service: Class<T>, baseHost: String, interceptors: Collection<Interceptor>?): T {
                return retrofitClient(HttpUrl.Builder().host(baseHost).build(),
                        interceptors).create(service)
            }


        }

    }
}

