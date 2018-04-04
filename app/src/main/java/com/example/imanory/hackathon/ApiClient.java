package com.example.imanory.hackathon;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jana on 4/4/2018 AD.
 */

public class ApiClient {

    public static final String BASE_URL="http://t6w3.net/api/";
    public static Retrofit retrofit=null;

    public static Retrofit getApiClient()
    {

if (retrofit==null)
{
    retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
}
        return retrofit;
    }
}
