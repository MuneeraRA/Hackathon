package com.example.imanory.hackathon.model.services;

import android.widget.Toast;

import com.example.imanory.hackathon.ApiClient;
import com.example.imanory.hackathon.R;
import com.example.imanory.hackathon.model.response.RegisterResponse;
import com.example.imanory.hackathon.presenter.LoginPresenter;
import com.example.imanory.hackathon.view.LoginView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jana on 4/5/2018 AD.
 */

public class LoginImp implements LoginPresenter {
    LoginView mLoginView;
    LoginPresenter loginPresenter;
    private RegisterResponse result;


    public LoginImp(LoginView LoginView) {

        this.mLoginView = LoginView;
    }

    @Override
    public Call<RegisterResponse> getLoginResult(String Password, String Email) {

        loginPresenter = ApiClient.getApiClient().create(LoginPresenter.class);
        Call<RegisterResponse> call = loginPresenter.getLoginResult(Password, Email);
        call.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                mLoginView.setResult(response.body());
            }
            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {

            }
        });
        return call;
    }
}
