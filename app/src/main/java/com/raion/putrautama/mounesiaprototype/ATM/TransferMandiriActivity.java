package com.raion.putrautama.mounesiaprototype.ATM;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.raion.putrautama.mounesiaprototype.Model.Bank;
import com.raion.putrautama.mounesiaprototype.Model.Pesanan;
import com.raion.putrautama.mounesiaprototype.Model.Users;
import com.raion.putrautama.mounesiaprototype.R;
import com.raion.putrautama.mounesiaprototype.TicketActivity;

public class TransferMandiriActivity extends AppCompatActivity {

    Users mUsers;
    Bank mBank;
    Pesanan mPesanan;

    TextView mTotalBayar;
    Button mTransfer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer_mandiri);

        mTotalBayar = findViewById(R.id.totalbayar);
        mTransfer = findViewById(R.id.transfer);
        mUsers = (Users) getIntent().getSerializableExtra("USER");
        mPesanan = (Pesanan) getIntent().getSerializableExtra("PESANAN");
        mBank = (Bank) getIntent().getSerializableExtra("BANK");

//        mTotalBayar.setText(String.valueOf(mPesanan.getHargaPaket()));

        mTransfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                writePesananToDatabase();
                Intent intent = new Intent(TransferMandiriActivity.this, TicketActivity.class);
                intent.putExtra("USER", mUsers);
                startActivity(intent);
                finish();
            }
        });
//        mTotalBayar.setText(mPesanan.getHargaPaket());
    }
    private void writePesananToDatabase() {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference();
        Bank bank = new Bank(mBank.getNamaBank());
        databaseReference.child("Users").child(mUsers.getUniqueId()).child("pesanan").child("atm").setValue(bank);
    }
}
