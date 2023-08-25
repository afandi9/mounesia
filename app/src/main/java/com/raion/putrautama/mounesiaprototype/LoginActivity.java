package com.raion.putrautama.mounesiaprototype;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.raion.putrautama.mounesiaprototype.Model.Users;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    TextView mRegisterText;
    public EditText mEmail,mPassword;
    Button mLogin;
    public static String email;
    public static String password;
    boolean validLogin = false;


    Users mUsers;
    ArrayList<Users> mUserList = new ArrayList<>();


    FirebaseDatabase database;
    DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);
        mRegisterText = findViewById(R.id.haveaccount);


        mLogin = findViewById(R.id.btnLogin);
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retriviewData();
                Login();
            }
        });

        HaveAcoount();
    }
    public void HaveAcoount(){
        mRegisterText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
    public void Login(){
        email = mEmail.getText().toString();
        password = mPassword.getText().toString();

        if(TextUtils.isEmpty(email) && TextUtils.isEmpty(password)){
            Toast.makeText(this,"Mohon masukan email dan password",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Mohon masukan email",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Mohon masukan password",Toast.LENGTH_LONG).show();
            return;
        }

        //start the profile activity
        for (Users tiapUser: mUserList) {
            validLogin = email.equals(tiapUser.getEmail()) && password.equals(tiapUser.getPassword());
            if(validLogin){
                mUsers = tiapUser;

                break;
            }
        }
        if(validLogin){
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            intent.putExtra("USER",mUsers);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(LoginActivity.this, "Email atau Password Salah", Toast.LENGTH_SHORT).show();
        }
    }

    private void retriviewData() {
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Users");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot userDataSnapshot : dataSnapshot.getChildren()) {
                    Users user = userDataSnapshot.getValue(Users.class);
                    mUserList.add(user);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
