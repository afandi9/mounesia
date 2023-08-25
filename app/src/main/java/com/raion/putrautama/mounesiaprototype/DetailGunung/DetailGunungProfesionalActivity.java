package com.raion.putrautama.mounesiaprototype.DetailGunung;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.raion.putrautama.mounesiaprototype.Booking.BookingProfesionalActivity;
import com.raion.putrautama.mounesiaprototype.Gunung.GunungProfesionalActivity;
import com.raion.putrautama.mounesiaprototype.Model.GunungProfesional;
import com.raion.putrautama.mounesiaprototype.Model.Users;
import com.raion.putrautama.mounesiaprototype.R;

public class DetailGunungProfesionalActivity extends AppCompatActivity {
    ImageView mBack;

    GunungProfesional gunungProfesional;
    Button mBooking;
    Users mUsers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_gunung_profesional);
        mUsers = (Users) getIntent().getSerializableExtra("USER");
        TextView NamaGunungProfesional = findViewById(R.id.namaGunungProfesionalDetail);
        TextView LokasiGunungProfesional = findViewById(R.id.lokasiGunungProfesionalDetail);
        TextView SuhuGunungProfesional = findViewById(R.id.suhuGunungProfesionalDetail);
        TextView DeskripsiGunungProfesional = findViewById(R.id.deskripsiGunungProfesionalDetail);
        TextView BarangGunungProfesional = findViewById(R.id.barangGunungProfesionalDetail);
        TextView KetinggianGunungProfesional = findViewById(R.id.ketinggianGunungProfesionalDetail);
        TextView RuteGunungProfesional = findViewById(R.id.ruteGunungProfesionalDetail);
        TextView PaketGunungProfesional = findViewById(R.id.paketGunungProfesionalDetail);
        TextView HargaGunungProfesional = findViewById(R.id.hargaGunungProfesionalDetail);

        gunungProfesional = (GunungProfesional) getIntent().getSerializableExtra("GunungProfesional");
        NamaGunungProfesional.setText(gunungProfesional.getNamaGunungProfesional());
        LokasiGunungProfesional.setText(gunungProfesional.getLokasiGunungProfesional());
        SuhuGunungProfesional.setText(gunungProfesional.getSuhuGunungProfesional());
        DeskripsiGunungProfesional.setText(gunungProfesional.getDeskripsiGunungProfesional());
        BarangGunungProfesional.setText(gunungProfesional.getBarangGunungProfesional());
        KetinggianGunungProfesional.setText(gunungProfesional.getKetinggianGunungProfesional());
        RuteGunungProfesional.setText(gunungProfesional.getRuteGunungProfesional());
        PaketGunungProfesional.setText(gunungProfesional.getPaketGunungProfesional());
        HargaGunungProfesional.setText(String.valueOf(gunungProfesional.getHargaGunungProfesional()));

        mBooking = findViewById(R.id.booking);
        mBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(DetailGunungProfesionalActivity.this, BookingProfesionalActivity.class);
                intent.putExtra("USER", mUsers);
                startActivity(intent);
            }
        });

        mBack = findViewById(R.id.back);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(DetailGunungProfesionalActivity.this,GunungProfesionalActivity.class);
                intent.putExtra("USER", mUsers);
                startActivity(intent);
            }
        });
    }
}
