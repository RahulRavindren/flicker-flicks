package com.flickerflics.common;

import android.os.AsyncTask;

import retrofit2.Call;
import surveyapp.com.network.utils.CallbackState;
import surveyapp.com.network.utils.CallbackWrapper;

/**
 * @Author rahulravindran
 */
public abstract class BaseRepository<IN, OUT> extends AsyncTask<IN, OUT, OUT> {

    protected void setCallback(Call call, CallbackState callback) {
        call.enqueue(new CallbackWrapper(callback));
    }


}
