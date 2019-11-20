package com.example.json_from_php;

import android.net.Uri;
import android.util.Log;

import com.koushikdutta.async.http.AsyncHttpClient;
import com.koushikdutta.async.http.AsyncHttpPost;
import com.koushikdutta.async.http.AsyncHttpResponse;

public class phpConn {//https://github.com/koush/AndroidAsync
    static String answer = null;
    static public String getAnswer(){return answer;}

    public void urlCon(String link) {
        Log.v("george", " trying: " + link);
        AsyncHttpClient.getDefaultInstance().executeString(
            new AsyncHttpPost(Uri.parse(link)), new AsyncHttpClient.StringCallback() {
                @Override
                public void onCompleted(Exception e, AsyncHttpResponse response, String result) {
                    if (e != null) {
                        e.printStackTrace();
                        Log.v("george:", "link failed...");
                        return;
                    }
                    answer = result; //if static no wait needed
                }
            });
    }

}
