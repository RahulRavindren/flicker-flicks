package surveyapp.com.network.utils;

import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import surveyapp.com.common.utils.Logger;
import surveyapp.com.common.utils.Utils;
import surveyapp.com.network.R;
import surveyapp.com.network.exceptions.BaseError;
import surveyapp.com.network.exceptions.NetworkConnectivityException;

/**
 * @Author rahulravindran
 */
public class CallbackWrapper<T> implements Callback<T> {
    final String TAG = CallbackWrapper.class.getSimpleName();
    private CallbackState callback;

    public CallbackWrapper(CallbackState callback) {
        this.callback = callback;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            if (callback != null) {
                callback.onSuccess(response.body());
            }
        } else {
            BaseError error = getError(call, response);
            callback.onError(error);
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        BaseError error = getError(t);
        callback.onError(t);
    }

    private BaseError getError(Call call, Response response) {
        int code = response.code();
        BaseError error = null;
        ResponseBody errorBody = response.errorBody();

        switch (code) {
            case HttpURLConnection.HTTP_INTERNAL_ERROR:
            case HttpURLConnection.HTTP_GATEWAY_TIMEOUT:
            case HttpURLConnection.HTTP_BAD_GATEWAY:
            case HttpURLConnection.HTTP_UNAVAILABLE:
                Logger.debug(TAG, "Server error :: " + code);
                error = new BaseError(Utils.Companion.getString(R.string.server_error));

        }
        if (error == null) {
            error = new BaseError();
        }

        if (errorBody != null) {
            errorBody.close();
        }


        return error;
    }

    private BaseError getError(Throwable t) {
        if (t instanceof SocketTimeoutException) {
            return new BaseError(Utils.Companion.getString(R.string.server_error));

        } else if (t instanceof NetworkConnectivityException) {
            return new BaseError(Utils.Companion.getString(R.string.no_network_msg));

        } else {
            return new BaseError();
        }
    }
}
