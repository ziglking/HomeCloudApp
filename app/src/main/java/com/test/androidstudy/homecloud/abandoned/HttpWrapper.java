package com.test.androidstudy.homecloud.abandoned;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.content.Context;

import com.test.androidstudy.homecloud.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;

/**
 * Created by wangxiang on 2017/11/19.
 */

public class HttpWrapper {

    static private OkHttpClient mHttpClient = new OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS).build();

    static private String doGet(String reqInterface, @Nullable  Context context) {
        Request request = new Request.Builder().url("http://jedi929.cn/homecloud/" + reqInterface)
                .header("User-Agent", "OkHttpDemo/1.0")
                .header("User-Agent", "OkHttpDemo/2.0")
                .addHeader("X-Key", "value1")
                .addHeader("X-Key", "value2").build();
        try {
            Response response = mHttpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                return response.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    static private String doPost(String reqInterface, @NonNull final Context context) {

        RequestBody requestBody = new RequestBody() {
            @Override
            public MediaType contentType() {
                return MediaType.parse("text/plain");
            }

            @Override
            public void writeTo(BufferedSink sink) throws IOException {
                InputStream inputStream = context.getResources().openRawResource(R.raw.data);
                byte[] buffer = new byte[1024];
                int read;
                while ((read = inputStream.read(buffer)) > 0) {
                    sink.write(buffer, 0, read);
                }
                sink.flush();
                inputStream.close();
            }
        };

        MultipartBody multipartBody = new MultipartBody.Builder().addPart(requestBody)
                .addPart(RequestBody.create(MediaType.parse("text/plain"),
                        "this is test data from code")).build();
        Request request = new Request.Builder().url("http://jedi929.cn/homecloud/" + reqInterface)
                .header("User-Agent", "OkHttpDemo/1.0")
                .method("POST", multipartBody)
                .build();
        try {
            Call call = mHttpClient.newCall(request);
            Response response = call.execute();
            if (response.isSuccessful()) {
                return response.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    static public String request(final String reqInterface, int httpMethod, Context context){
        switch (httpMethod){
                case HttpMethod.GET:
                    return doGet(reqInterface, context);
                case HttpMethod.POST:
                    return doPost(reqInterface, context);
                case HttpMethod.DELETE:
                    return null;
                case HttpMethod.PUT:
                    return null;
                default:
                    return null;
        }
    }

}

class HttpMethod {
    public static final int POST = 2;
    public static final int GET = 1;
    public static final int DELETE = 3;
    public static final int PUT = 4;
}
