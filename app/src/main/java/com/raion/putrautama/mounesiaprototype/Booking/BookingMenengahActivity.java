package com.raion.putrautama.mounesiaprototype.Booking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.raion.putrautama.mounesiaprototype.Model.GunungMenengah;
import com.raion.putrautama.mounesiaprototype.Model.GunungPemula;
import com.raion.putrautama.mounesiaprototype.Model.Pesanan;
import com.raion.putrautama.mounesiaprototype.Model.Users;
import com.raion.putrautama.mounesiaprototype.Pembayaran.PembayaranMenengahActivity;
import com.raion.putrautama.mounesiaprototype.Pembayaran.PembayaranPemulaActivity;
import com.raion.putrautama.mounesiaprototype.R;

public class BookingMenengahActivity extends AppCompatActivity {

    Users mUsers;
    GunungMenengah gunungMenengah;
    Pesanan mPesanan;
    Button mMembayar;

    EditText mNama,mNotlp,mEmail,mTglBooking,mJumlahOrang,mCatatanTambahan;
    String nama;
    String notlp;
    String email;
    String tglBooking;
    int jumlahOrang = 0;
    String catatanTambahan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_menengah);

        mNama = findViewById(R.id.nama);
        mNotlp = findViewById(R.id.notlp);
        mEmail = findViewById(R.id.email);
        mTglBooking = findViewById(R.id.tglbooking);
        mJumlahOrang = findViewById(R.id.jumlahorang);
        mCatatanTambahan = findViewById(R.id.catatanTambahan);

        gunungMenengah = (GunungMenengah) getIntent().getSerializableExtra("GunungMenengah");
        mPesanan = (Pesanan) getIntent().getSerializableExtra("PESANAN");

        mUsers = (Users) getIntent().getSerializableExtra("USER");
        mMembayar = findViewById(R.id.membayar);
        mMembayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Booking();
                finish();

            }
        });
    }
    private void writePesananToDatabase() {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference();
//        String namaGunung, String lokasiGunung, String suhuGunung
//                , String deskripsiGunung, String barangGunung, String ketinggianGunung
//                , String ruteGunung, String paketGunung, int fotoGunung, String nama
//                , String notlp, String email, String tglBooking, String jumlahOrang
//                , String catatanTambahan
        Pesanan pesanan = new Pesanan(gunungMenengah.getNamaGunungMenengah()
                , gunungMenengah.getLokasiGunungMenengah()
                , gunungMenengah.getSuhuGunungMenengah()
                , gunungMenengah.getDeskripsiGunungMenengah()
                , gunungMenengah.getBarangGunungMenengah()
                , gunungMenengah.getKetinggianGunungMenengah()
                , gunungMenengah.getRuteGunungMenengah()
                , gunungMenengah.getPaketGunungMenengah()
                , jumlahOrang * gunungMenengah.getHargaGunungMenengah()
                , gunungMenengah.getFotoGunungMenengah()
                , nama
                , notlp
                , email
                , tglBooking
                , jumlahOrang
                , catatanTambahan);
        databaseReference.child("Users").child(mUsers.getUniqueId()).child("pesanan").push().setValue(pesanan);

    }
    private void Booking(){
        nama = mNama.getText().toString();
        notlp = mNotlp.getText().toString();
        email = mEmail.getText().toString();
        tglBooking = mTglBooking.getText().toString();
        jumlahOrang= Integer.parseInt(mJumlahOrang.getText().toString());
        catatanTambahan  = mCatatanTambahan.getText().toString();

        if(TextUtils.isEmpty(nama)){
            Toast.makeText(this,"Mohon masukan nama",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(notlp)){
            Toast.makeText(this,"Mohon masukan no telepon",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Mohon masukan email",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(tglBooking)){
            Toast.makeText(this,"Mohon masukan tanggal booking",Toast.LENGTH_LONG).show();
            return;
        }
        if(jumlahOrang == 0){
            Toast.makeText(this,"Mohon masukan jumlah orang",Toast.LENGTH_LONG).show();
            return;
        }
        writePesananToDatabase();
        Intent intent = new Intent(BookingMenengahActivity.this, PembayaranMenengahActivity.class);
        intent.putExtra("GunungMenengah",gunungMenengah);
        intent.putExtra("PESANAN",mPesanan);
        intent.putExtra("USER", mUsers);
        startActivity(intent);
    }

}
