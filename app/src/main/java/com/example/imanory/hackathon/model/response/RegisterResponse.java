package com.example.imanory.hackathon.model.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jana on 4/4/2018 AD.
 */

public class RegisterResponse {

    @SerializedName("status")
    private int Status;
    @SerializedName("error")
    private String Error;

    public int getStatus() {
        return Status;
    }

    public String getError() {
        return Error;
    }
}
