package com.example.imanory.hackathon.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.imanory.hackathon.R;
import com.example.imanory.hackathon.base.Base;
import com.example.imanory.hackathon.model.response.RegisterResponse;
import com.example.imanory.hackathon.model.services.LoginImp;
import com.example.imanory.hackathon.model.services.RegisterImp;
import com.example.imanory.hackathon.presenter.LoginPresenter;
import com.example.imanory.hackathon.presenter.RegisterPresenter;
import com.example.imanory.hackathon.view.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jana on 4/4/2018 AD.
 */

public class Login  extends AppCompatActivity implements LoginView{
    public  static LoginPresenter loginPresenter;
    @BindView(R.id.login_btn) Button Login;

    @BindView(R.id.email_edt)
    EditText emailEdt;
    @BindView(R.id.password_edt) EditText passwordEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        ButterKnife.bind(this);
        loginPresenter = new LoginImp(Login.this);

    }


    @OnClick(R.id.login_btn)
    public void login() {
       if (emailEdt.getText().toString().trim().length()>0 || passwordEdt.getText().toString().length()>0){

           if (Base.isEmailValid(emailEdt.getText().toString().trim())){
            /**/loginPresenter.getLoginResult(emailEdt.getText().toString(),passwordEdt.getText().toString());}
       else {
           // Not Valid Email
           Toast.makeText(this,this.getResources().getString(R.string.email_empty_error_message),Toast.LENGTH_LONG).show();
           }
       }
        else {
           Toast.makeText(this,this.getResources().getString(R.string.empty_fields_error_message),Toast.LENGTH_LONG).show();

       }
    }
    @OnClick(R.id.create_btn)
    public void register(){
        Intent intent = new Intent(this,Register.class);
        startActivity(intent);
    }
    @Override
    public void setResult(RegisterResponse result) {
      Toast.makeText(this,result.getError(),Toast.LENGTH_LONG).show();
       // Toast.makeText(this,result.getStatus(),Toast.LENGTH_LONG).show();
    }
}
