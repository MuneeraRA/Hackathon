package com.example.imanory.hackathon.model.services;

import com.example.imanory.hackathon.ApiClient;
import com.example.imanory.hackathon.model.response.RegisterResponse;
import com.example.imanory.hackathon.presenter.RegisterPresenter;
import com.example.imanory.hackathon.view.RegisterView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jana on 4/4/2018 AD.
 */

public class RegisterImp implements RegisterPresenter {
    RegisterView mRegisterView;
    RegisterPresenter registerPresenter;
    private RegisterResponse result;

    public RegisterImp(RegisterView RegisterView) {

        this.mRegisterView = RegisterView;
    }
    @Override
    public Call<RegisterResponse> getRegisterResult(String UserName, String Password, String Email) {
        registerPresenter = ApiClient.getApiClient().create(RegisterPresenter.class);
        Call<RegisterResponse> call = registerPresenter.getRegisterResult(UserName, Password, Email);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                result = (RegisterResponse) response.body();
                mRegisterView.setResult(result);
            }

            @Override
            public void onFailure(Call call, Throwable t) {

            }
        });

        return call;

    }

    }
