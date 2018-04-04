package com.example.imanory.hackathon.presenter;

import com.example.imanory.hackathon.model.response.RegisterResponse;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by jana on 4/4/2018 AD.
 */

public interface RegisterPresenter {

    @POST("register")
    @FormUrlEncoded
    Call<RegisterResponse> getRegisterResult(@Field("userName") String UserName, @Field("password") String Password, @Field("email") String Email);
}
