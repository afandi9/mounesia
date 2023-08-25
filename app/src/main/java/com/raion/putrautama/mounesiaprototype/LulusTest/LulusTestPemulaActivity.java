package com.raion.putrautama.mounesiaprototype.LulusTest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.raion.putrautama.mounesiaprototype.Gunung.GunungPemulaActivity;
import com.raion.putrautama.mounesiaprototype.Model.Users;
import com.raion.putrautama.mounesiaprototype.R;

public class LulusTestPemulaActivity extends AppCompatActivity {
    Button mBtnNext;
    Users mUsers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lulus_test_pemula);

        mUsers = (Users) getIntent().getSerializableExtra("USER");
        mBtnNext = findViewById(R.id.btnnextpemula);

        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(LulusTestPemulaActivity.this, GunungPemulaActivity.class);
                intent.putExtra("USER", mUsers);
                startActivity(intent);
            }
        });
    }
}
