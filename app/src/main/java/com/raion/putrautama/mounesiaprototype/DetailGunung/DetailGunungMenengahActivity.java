package com.raion.putrautama.mounesiaprototype.DetailGunung;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.raion.putrautama.mounesiaprototype.Booking.BookingMenengahActivity;
import com.raion.putrautama.mounesiaprototype.Booking.BookingProfesionalActivity;
import com.raion.putrautama.mounesiaprototype.Gunung.GunungMenengahActivity;
import com.raion.putrautama.mounesiaprototype.Model.GunungMenengah;
import com.raion.putrautama.mounesiaprototype.Model.Users;
import com.raion.putrautama.mounesiaprototype.R;

public class DetailGunungMenengahActivity extends AppCompatActivity {
    ImageView mBack;

    GunungMenengah gunungMenengah;
    Button mBooking;
    Users mUsers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_gunung_menengah);
        mUsers = (Users) getIntent().getSerializableExtra("USER");
        TextView NamaGunungPemula = findViewById(R.id.namaGunungMenengahDetail);
        TextView LokasiGunungPemula = findViewById(R.id.lokasiGunungMenengahDetail);
        TextView SuhuGunungPemula = findViewById(R.id.suhuGunungMenengahDetail);
        TextView DeskripsiGunungPemula = findViewById(R.id.deskripsiGunungMenengahDetail);
        TextView BarangGunungPemula = findViewById(R.id.barangGunungMenengahDetail);
        TextView KetinggianGunungPemula = findViewById(R.id.ketinggianGunungMenengahDetail);
        TextView RuteGunungPemula = findViewById(R.id.ruteGunungMenengahDetail);
        TextView HargaGunungMenengah = findViewById(R.id.hargaGunungMenengahDetail);
        TextView PaketGunungPemula = findViewById(R.id.paketGunungMenengahDetail);


        gunungMenengah = (GunungMenengah) getIntent().getSerializableExtra("GunungMenengah");
        NamaGunungPemula.setText(gunungMenengah.getNamaGunungMenengah());
        LokasiGunungPemula.setText(gunungMenengah.getLokasiGunungMenengah());
        SuhuGunungPemula.setText(gunungMenengah.getSuhuGunungMenengah());
        DeskripsiGunungPemula.setText(gunungMenengah.getDeskripsiGunungMenengah());
        BarangGunungPemula.setText(gunungMenengah.getBarangGunungMenengah());
        KetinggianGunungPemula.setText(gunungMenengah.getKetinggianGunungMenengah());
        RuteGunungPemula.setText(gunungMenengah.getRuteGunungMenengah());
        PaketGunungPemula.setText(gunungMenengah.getPaketGunungMenengah());
        HargaGunungMenengah.setText(String.valueOf(gunungMenengah.getHargaGunungMenengah()));


        mBooking = findViewById(R.id.booking);
        mBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(DetailGunungMenengahActivity.this, BookingMenengahActivity.class);
                intent.putExtra("GunungMenengah", gunungMenengah);
                intent.putExtra("USER", mUsers);
                startActivity(intent);
            }
        });

        mBack = findViewById(R.id.back);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(DetailGunungMenengahActivity.this,GunungMenengahActivity.class);
                intent.putExtra("USER", mUsers);
                startActivity(intent);
            }
        });
    }
}
