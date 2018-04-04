package com.example.imanory.hackathon.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.imanory.hackathon.R;
import com.example.imanory.hackathon.model.response.RegisterResponse;
import com.example.imanory.hackathon.model.services.LoginImp;
import com.example.imanory.hackathon.model.services.RegisterImp;
import com.example.imanory.hackathon.presenter.LoginPresenter;
import com.example.imanory.hackathon.presenter.RegisterPresenter;
import com.example.imanory.hackathon.view.LoginView;

/**
 * Created by jana on 4/4/2018 AD.
 */

public class Login  extends AppCompatActivity implements LoginView{
    public  static LoginPresenter loginPresenter;
    Button Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        loginPresenter = new LoginImp(Login.this);
        Login=(Button)findViewById(R.id.login_btn);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.getLoginResult("1234","Jana.s25@gmail.com");
            }
        });

    }

    @Override
    public void setResult(RegisterResponse result) {
      //  Toast.makeText(this,result.getError(),Toast.LENGTH_LONG).show();
       // Toast.makeText(this,result.getStatus(),Toast.LENGTH_LONG).show();
    }
}
