package com.raion.putrautama.mounesiaprototype.GagalTest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.raion.putrautama.mounesiaprototype.MainActivity;
import com.raion.putrautama.mounesiaprototype.Model.Users;
import com.raion.putrautama.mounesiaprototype.R;

public class GagalTestProfesionalActivity extends AppCompatActivity {
    Button mBtnCobaLagi;
    Users mUsers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gagal_test_profesional);

        mBtnCobaLagi = findViewById(R.id.btncoba);
        mUsers = (Users) getIntent().getSerializableExtra("USER");
        mBtnCobaLagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(GagalTestProfesionalActivity.this, MainActivity.class);
                intent.putExtra("USER", mUsers);
                startActivity(intent);
            }
        });
    }
}
