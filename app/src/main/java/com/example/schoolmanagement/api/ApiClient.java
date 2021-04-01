package com.example.schoolmanagement.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static final String BASE_URL = "http://192.168.1.19/newone/";
    public static final  String Asset_url = "http://192.168.1.34/newone/SchoolManegment/pdf/";

    public static Retrofit retrofit = null;

    public static Gson gson = new GsonBuilder().setLenient().create();

    public static Retrofit getClient() {
        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }

        return retrofit;
    }
}
