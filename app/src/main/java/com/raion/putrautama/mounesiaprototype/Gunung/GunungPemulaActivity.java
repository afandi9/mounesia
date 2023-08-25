package com.raion.putrautama.mounesiaprototype.Gunung;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.raion.putrautama.mounesiaprototype.Adapter.GunungPemulaAdapter;
import com.raion.putrautama.mounesiaprototype.MainActivity;
import com.raion.putrautama.mounesiaprototype.Model.GunungPemula;
import com.raion.putrautama.mounesiaprototype.Model.Users;
import com.raion.putrautama.mounesiaprototype.R;

import java.util.ArrayList;
import java.util.List;

public class GunungPemulaActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private GunungPemulaAdapter Adapter;
    private List<GunungPemula> mGunungPemulaList;

    ImageView mBack;
    Users mUsers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gunung_pemula);

        mUsers = (Users) getIntent().getSerializableExtra("USER");

        mBack = findViewById(R.id.back);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(GunungPemulaActivity.this,MainActivity.class);
                intent.putExtra("USER", mUsers);
                startActivity(intent);
            }
        });


        mRecyclerView = findViewById(R.id.recycler_viewPemula);
        mGunungPemulaList = new ArrayList<>();
        Adapter = new GunungPemulaAdapter(mGunungPemulaList, this,mUsers);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(Adapter);

        preaperedGunung();
    }

    private void preaperedGunung(){
//        int [] fotoGunungPemula = new int[]{
//                R.mipmap.bromo
//        };


        GunungPemula gunungPemula = new GunungPemula("Gunung Bromo",
                "Tosari, Pasuruan, Jawa Timur",
                "3-22 C","Bromo adalah gunung api aktif dan bagian dari massif Tengger dan merupakan salah satu tempat wisata yang paling banyak dikunjungi di Indonesia."
                ,"Jaket tebal","2329 mdpl"
                ,"Rute yang digunakan untuk menuju gunung bromo cukup dengan menggunakan kendaraan."
                ,"-termasuk travel dari dan ke daerah malang/Batu/Surabaya -Menikmati 3 obek wisata -Makan 1x, Snack dan air mineral -Asuransi -Masker -P3K"
                ,300000
                ,"https://services.sportourism.id/fileload/salju-bromo-2jpg-Pd45.jpg?q=75");
        mGunungPemulaList.add(gunungPemula);

        Adapter.notifyDataSetChanged();
    }
}
