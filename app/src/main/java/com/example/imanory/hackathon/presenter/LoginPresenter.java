package com.example.imanory.hackathon.presenter;

import com.example.imanory.hackathon.model.response.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by jana on 4/5/2018 AD.
 */

public interface LoginPresenter {

    @POST("login")
    @FormUrlEncoded
    Call<RegisterResponse> getLoginResult(@Field("password") String Password, @Field("email") String Email);
}
