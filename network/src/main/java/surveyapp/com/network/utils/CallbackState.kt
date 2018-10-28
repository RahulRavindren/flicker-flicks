package surveyapp.com.network.utils

/**
 * @Author rahulravindran
 */
interface CallbackState<T> {
    fun onSuccess(value: T)
    fun onError(error: Throwable)
}