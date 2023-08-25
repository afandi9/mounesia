package com.raion.putrautama.mounesiaprototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.raion.putrautama.mounesiaprototype.Model.Users;

public class TicketActivity extends AppCompatActivity {

    Users mUsers;
    Button mTicket;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);
        mUsers = (Users) getIntent().getSerializableExtra("USER");
        mTicket = findViewById(R.id.btnticket);
        mTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(TicketActivity.this, MainActivity.class);
                intent.putExtra("USER", mUsers);
                startActivity(intent);
            }
        });
    }
}
