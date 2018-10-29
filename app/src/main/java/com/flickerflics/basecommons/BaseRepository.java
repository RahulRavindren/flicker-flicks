package com.flickerflics.basecommons;

import com.flickerflics.network.utils.CallbackState;
import com.flickerflics.network.utils.CallbackWrapper;

import retrofit2.Call;

/**
 * @Author rahulravindran
 */
public abstract class BaseRepository<IN, OUT> {

    protected void setCallback(Call call, CallbackState callback) {
        call.enqueue(new CallbackWrapper(callback));
    }


}
