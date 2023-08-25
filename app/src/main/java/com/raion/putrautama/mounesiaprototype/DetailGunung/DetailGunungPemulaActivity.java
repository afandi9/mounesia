package com.raion.putrautama.mounesiaprototype.DetailGunung;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.raion.putrautama.mounesiaprototype.Booking.BookingPemulaActivity;
import com.raion.putrautama.mounesiaprototype.Gunung.GunungPemulaActivity;
import com.raion.putrautama.mounesiaprototype.Model.GunungPemula;
import com.raion.putrautama.mounesiaprototype.Model.Users;
import com.raion.putrautama.mounesiaprototype.R;

public class DetailGunungPemulaActivity extends AppCompatActivity {
    ImageView mBack;


    Button mBooking;
    GunungPemula gunungPemula;
    Users mUsers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_gunung_pemula);
        mUsers = (Users) getIntent().getSerializableExtra("USER");
        TextView NamaGunungPemula = findViewById(R.id.namaGunungPemulaDetail);
        TextView LokasiGunungPemula = findViewById(R.id.lokasiGunungPemulaDetail);
        TextView SuhuGunungPemula = findViewById(R.id.suhuGunungPemulaDetail);
        TextView DeskripsiGunungPemula = findViewById(R.id.deskripsiGunungPemulaDetail);
        TextView BarangGunungPemula = findViewById(R.id.barangGunungPemulaDetail);
        TextView KetinggianGunungPemula = findViewById(R.id.ketinggianGunungPemulaDetail);
        TextView RuteGunungPemula = findViewById(R.id.ruteGunungPemulaDetail);
        TextView PaketGunungPemula = findViewById(R.id.paketGunungPemulaDetail);
        TextView HargaGunungPemula = findViewById(R.id.hargaGunungPemulaDetail);




        gunungPemula = (GunungPemula) getIntent().getSerializableExtra("GunungPemula");
        NamaGunungPemula.setText(gunungPemula.getNamaGunungPemula());
        LokasiGunungPemula.setText(gunungPemula.getLokasiGunungPemula());
        SuhuGunungPemula.setText(gunungPemula.getSuhuGunungPemula());
        DeskripsiGunungPemula.setText(gunungPemula.getDeskripsiGunungPemula());
        BarangGunungPemula.setText(gunungPemula.getBarangGunungPemula());
        KetinggianGunungPemula.setText(gunungPemula.getKetinggianGunungPemula());
        RuteGunungPemula.setText(gunungPemula.getRuteGunungPemula());
        PaketGunungPemula.setText(gunungPemula.getPaketGunungPemula());
        HargaGunungPemula.setText(String.valueOf(gunungPemula.getHargaGunungPemula()));

        mBooking = findViewById(R.id.booking);
        mBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(DetailGunungPemulaActivity.this, BookingPemulaActivity.class);
                intent.putExtra("GunungPemula", gunungPemula);
                intent.putExtra("USER", mUsers);
                startActivity(intent);
            }
        });
        mBack = findViewById(R.id.back);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(DetailGunungPemulaActivity.this,GunungPemulaActivity.class);
                intent.putExtra("USER", mUsers);
                startActivity(intent);
            }
        });
    }


}
