package com.raion.putrautama.mounesiaprototype;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.raion.putrautama.mounesiaprototype.Model.Users;

public class RegisterActivity extends AppCompatActivity {

    TextView mHaveAccount;
    EditText mEmail,mPassword,mUsername,mNamaLengkap,mNoHp;
    Button mRegister;

    FirebaseDatabase mDatabase;
    DatabaseReference myRef;
    Users mUsers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

//        mUsers = (Users) getIntent().getSerializableExtra("USER");
        mEmail = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);
        mUsername = findViewById(R.id.username);
        mNamaLengkap = findViewById(R.id.namaLengkap);
        mNoHp = findViewById(R.id.noHp);
        mHaveAccount = findViewById(R.id.haveaccount);

        mRegister = findViewById(R.id.btnRegister);
        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register();
            }
        });
        AllreadyHaveAcoount();
    }
    public void Register(){
        String username = mUsername.getText().toString().trim();
        String email = mEmail.getText().toString().trim();
        String password  = mPassword.getText().toString().trim();
        String noHp = mNoHp.getText().toString().trim();
        String namaLengkap = mNamaLengkap.getText().toString().trim();


        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Mohon masukan email",Toast.LENGTH_LONG).show();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Toast.makeText(this, "Mohon masukan email yang valid", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Mohon masukan password",Toast.LENGTH_LONG).show();
            return;
        }
        if (password.length()<6){
            Toast.makeText(this, "Password minimal harus terdiri dari 6 karakter", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(username)){
            Toast.makeText(this,"Mohon masukan username",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(noHp)){
            Toast.makeText(this,"Mohon masukan no tlp",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(namaLengkap)){
            Toast.makeText(this,"Mohon masukan nama lengkap",Toast.LENGTH_LONG).show();
            return;
        }
        if (email.contains("@")){
            writeToDatabase(username,namaLengkap,noHp,email,password);
            Toast.makeText(RegisterActivity.this, "Registrasi berhasil", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(RegisterActivity.this, "Registrasi Gagal", Toast.LENGTH_SHORT).show();
        }
    }

    public void writeToDatabase(String username,String namalengkap,
                                String notlp, String email, String password ){
        mDatabase = FirebaseDatabase.getInstance();
        myRef = mDatabase.getReference("Users");

        String uniqueId = myRef.push().getKey().toString();
        Users users = new Users(username,namalengkap,notlp,email, password,uniqueId, null,null,null,null,null);
        myRef.child(uniqueId).setValue(users);
    }


    public void AllreadyHaveAcoount(){
        mHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
