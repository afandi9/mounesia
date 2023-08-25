package com.raion.putrautama.mounesiaprototype.Pembayaran;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.raion.putrautama.mounesiaprototype.ATM.TransferBCAActivity;
import com.raion.putrautama.mounesiaprototype.ATM.TransferBRIActivity;
import com.raion.putrautama.mounesiaprototype.ATM.TransferMandiriActivity;
import com.raion.putrautama.mounesiaprototype.Booking.BookingPemulaActivity;
import com.raion.putrautama.mounesiaprototype.Model.Pesanan;
import com.raion.putrautama.mounesiaprototype.Model.Users;
import com.raion.putrautama.mounesiaprototype.R;
import com.raion.putrautama.mounesiaprototype.ATM.TransferBNIActivity;

public class PembayaranPemulaActivity extends AppCompatActivity {
    ImageView mBack;
    Button mBtnBCA,mBtnBNI,mBtnMandiri,mBtnBRI;
    Users mUsers;
    Pesanan mPesanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembayaran_pemula);
        mPesanan = (Pesanan) getIntent().getSerializableExtra("PESANAN");
        mUsers = (Users) getIntent().getSerializableExtra("USER");

        mBtnBCA = findViewById(R.id.BtnBca);
        mBtnBNI = findViewById(R.id.BtnBni);
        mBtnBRI = findViewById(R.id.BtnBri);
        mBtnMandiri = findViewById(R.id.BtnMandiri);


        mBack = findViewById(R.id.back);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(PembayaranPemulaActivity.this,BookingPemulaActivity.class);
                intent.putExtra("USER", mUsers);
                startActivity(intent);
            }
        });

        mBtnBCA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(PembayaranPemulaActivity.this,TransferBCAActivity.class);
                intent.putExtra("PESANAN",mPesanan);
                intent.putExtra("USER", mUsers);
                startActivity(intent);
            }
        });

        mBtnBRI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(PembayaranPemulaActivity.this,TransferBRIActivity.class);
                intent.putExtra("PESANAN",mPesanan);
                intent.putExtra("USER", mUsers);
                startActivity(intent);
            }
        });
        mBtnMandiri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(PembayaranPemulaActivity.this,TransferMandiriActivity.class);
                intent.putExtra("PESANAN",mPesanan);
                intent.putExtra("USER", mUsers);
                startActivity(intent);
            }
        });
        mBtnBNI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(PembayaranPemulaActivity.this,TransferBNIActivity.class);
                intent.putExtra("PESANAN",mPesanan);
                intent.putExtra("USER", mUsers);
                startActivity(intent);
            }
        });
    }

}
