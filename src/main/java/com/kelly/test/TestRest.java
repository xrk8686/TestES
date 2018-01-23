package com.kelly.test;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestRest {
    public static void main(String[] args) throws IOException {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout(40, TimeUnit.SECONDS);
        OkHttpClient client = builder.build();

        ExecutorService ex = Executors.newCachedThreadPool();

        for (int i = 0; i < 100; i++) {
            ex.execute(()->{
                okhttp3.Request request = new Request.Builder()
                        .url("http://localhost:8080/saveRequest")
                        .get()
                        .addHeader("cache-control", "no-cache")
                        .addHeader("postman-token", "2efe4ab2-dcda-63ab-25d2-fa58b5520b9d")
                        .build();

                Response response = null;
                try {
                    response = client.newCall(request).execute();
                    System.out.println(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }

        ex.shutdown();
    }
}
