package com.raion.putrautama.mounesiaprototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginOrRegisterActivity extends AppCompatActivity {
    Button mLogin,mRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_or_register);
        mLogin = findViewById(R.id.btnLogin);
        mRegister = findViewById(R.id.btnRegister);

        Login();
        Register();
    }

    public void Login(){
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(LoginOrRegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    public void Register(){
        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(LoginOrRegisterActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
