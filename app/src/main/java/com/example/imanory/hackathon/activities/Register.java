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
import com.example.imanory.hackathon.model.services.RegisterImp;
import com.example.imanory.hackathon.model.response.RegisterResponse;
import com.example.imanory.hackathon.presenter.RegisterPresenter;
import com.example.imanory.hackathon.view.RegisterView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by jana on 4/4/2018 AD.
 */

public class Register  extends AppCompatActivity implements RegisterView{
   public  static RegisterPresenter registerPresenter;
    @BindView(R.id.login_btn) Button Login;

    @BindView(R.id.email_edt)
    EditText emailEdt;
    @BindView(R.id.password_edt) EditText passwordEdt;
    @BindView(R.id.username_edt) EditText usernameEdt;

Button Create;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        registerPresenter = new RegisterImp(Register.this);
        Create=(Button)findViewById(R.id.creat_btn);
        Create.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            registerPresenter.getRegisterResult("jana72","1234","Jana.s25@gmail.com");
        }
    });

        }


    @OnClick(R.id.creat_btn)
    public void create() {
        if (emailEdt.getText().toString().trim().length()>0){

            if (Base.isEmailValid(emailEdt.getText().toString().trim())){
            /**/registerPresenter.getRegisterResult(usernameEdt.getText().toString(),passwordEdt.getText().toString(),emailEdt.getText().toString());}
            else {
                // Not Valid Email
                Toast.makeText(this,this.getResources().getString(R.string.email_empty_error_message),Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(this,this.getResources().getString(R.string.email_empty_error_message),Toast.LENGTH_LONG).show();

        }
    }
    @OnClick(R.id.login_btn)
    public void login(){
        Intent intent = new Intent(this,Login.class);
        intent.putExtra("check",true);
        startActivity(intent);
    }
    @Override
    public void setResult(RegisterResponse result) {
        Toast.makeText(this,result.getError(),Toast.LENGTH_LONG).show();
        // Toast.makeText(this,result.getStatus(),Toast.LENGTH_LONG).show();
    }

}
