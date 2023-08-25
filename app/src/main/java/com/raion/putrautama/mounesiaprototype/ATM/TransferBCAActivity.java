package com.raion.putrautama.mounesiaprototype.ATM;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.raion.putrautama.mounesiaprototype.Model.Bank;
import com.raion.putrautama.mounesiaprototype.Model.Pesanan;
import com.raion.putrautama.mounesiaprototype.Model.Users;
import com.raion.putrautama.mounesiaprototype.R;
import com.raion.putrautama.mounesiaprototype.TicketActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class TransferBCAActivity extends AppCompatActivity {

    Users mUsers;
    Bank mBank;
    Pesanan mPesanan;
    TextView mTotalBayar;
    Button mTransfer;
    FirebaseDatabase database;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer_bca);
        mTotalBayar = findViewById(R.id.totalbayar);
        mTransfer = findViewById(R.id.transfer);
        mUsers = (Users) getIntent().getSerializableExtra("USER");
        mPesanan = (Pesanan) getIntent().getSerializableExtra("PESANAN");
        mBank = (Bank) getIntent().getSerializableExtra("BANK");

//        database = FirebaseDatabase.getInstance();
//        myRef = database.getReference("Users");
//        myRef.child(mUsers.getUniqueId()).child("pesanam").child("hargaPaket").getKey();

        mTransfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                writePesananToDatabase();
                Intent intent = new Intent(TransferBCAActivity.this, TicketActivity.class);
                intent.putExtra("USER", mUsers);
                startActivity(intent);
                finish();
            }
        });

//        mTotalBayar.setText(String.valueOf(mPesanan.getHargaPaket()));
//        mTotalBayar.setText(mPesanan.getNamaGunung());

    }
//    private void writePesananToDatabase() {
//        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
//        DatabaseReference databaseReference = firebaseDatabase.getReference();
//        Bank bank = new Bank(mBank.getNamaBank());
//        databaseReference.child("Users").child(mUsers.getUniqueId()).child("pesanan").child("atm").setValue(bank);
//    }

}
