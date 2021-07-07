package com.example.intentfilterwe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText  mEtuseranme;
    private EditText mEtEmail;
    private EditText mEtPassword;
    private Button btnLogin;
    private String emailvalidation="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intiViews();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUsernamevalid=isUsernamevalid();
                boolean isPasswordValid=isPasswordValid();
                boolean isemailValid=isemailvalid();
                if(isemailvalid()&&isPasswordValid()&&isUsernamevalid()){
                    Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                    intent.putExtra("username",mEtuseranme.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }

    private void intiViews() {
        mEtuseranme=findViewById(R.id.etUsername);
        mEtEmail=findViewById(R.id.etEmail);
        mEtPassword=findViewById(R.id.etPassword);
        btnLogin=findViewById(R.id.btnLogin);
    }
    private boolean isemailvalid() {
        if ( mEtEmail.getText().toString().matches(emailvalidation)){
            return true;
        }else {
            mEtEmail.setError("Invalid email");
            return false;
        }
    }
    private boolean isPasswordValid(){
        if(mEtPassword.getText().toString().trim().length()>=6){
            return true;
        }else{
            mEtPassword.setError("Password length is less than 6 characters");
            return false;
        }
    }
    private boolean isUsernamevalid(){
        if(mEtuseranme.getText().toString().trim().length()>=6){
            return true;
        }else{
            return false;
        }
    }

}