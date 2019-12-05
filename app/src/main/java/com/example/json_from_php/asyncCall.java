package com.example.json_from_php;
import android.util.Log;

import com.koushikdutta.async.http.AsyncHttpClient;
import com.koushikdutta.async.http.AsyncHttpGet;
import com.koushikdutta.async.http.AsyncHttpResponse;

public class asyncCall {
    public String execute(String url) {
        String ret = null;
        try {
            ret = AsyncHttpClient.getDefaultInstance()
                    .executeString(new AsyncHttpGet(url), null)
                    .get();
            //Log.v("george ret",ret);
        } catch (Exception e) {
            Log.e("Error", e.toString());
        }
        return ret;
    }
}
