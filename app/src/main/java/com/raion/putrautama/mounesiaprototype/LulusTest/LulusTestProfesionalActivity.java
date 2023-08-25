package com.raion.putrautama.mounesiaprototype.LulusTest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.raion.putrautama.mounesiaprototype.Gunung.GunungProfesionalActivity;
import com.raion.putrautama.mounesiaprototype.Model.Users;
import com.raion.putrautama.mounesiaprototype.R;

public class LulusTestProfesionalActivity extends AppCompatActivity {
    Button mBtnNext;
    Users mUsers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lulus_test_profesional);
        mBtnNext = findViewById(R.id.btnnextprofesional);
        mUsers = (Users) getIntent().getSerializableExtra("USER");

        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(LulusTestProfesionalActivity.this, GunungProfesionalActivity.class);
                intent.putExtra("USER", mUsers);
                startActivity(intent);
            }
        });
    }
}
