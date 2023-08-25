package com.raion.putrautama.mounesiaprototype.Gunung;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.raion.putrautama.mounesiaprototype.Adapter.GunungMenengahAdapter;
import com.raion.putrautama.mounesiaprototype.MainActivity;
import com.raion.putrautama.mounesiaprototype.Model.GunungMenengah;
import com.raion.putrautama.mounesiaprototype.Model.Users;
import com.raion.putrautama.mounesiaprototype.R;

import java.util.ArrayList;
import java.util.List;

public class GunungMenengahActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private GunungMenengahAdapter Adapter;
    private List<GunungMenengah> mGunungMenengahList;


    ImageView mBack;
    Users mUsers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gunung_menengah);

        mUsers = (Users) getIntent().getSerializableExtra("USER");

        mBack = findViewById(R.id.back);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(GunungMenengahActivity.this,MainActivity.class);
                intent.putExtra("USER", mUsers);
                startActivity(intent);
            }
        });

        mRecyclerView = findViewById(R.id.recycler_viewMenengah);
        mGunungMenengahList = new ArrayList<>();
        Adapter = new GunungMenengahAdapter(mGunungMenengahList, this,mUsers);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(Adapter);

        preaperedGunung();
    }

    private void preaperedGunung(){
//        int [] fotoGunungPemula = new int[]{
//                R.mipmap.arjuno,
//                R.mipmap.ijen
//        };


        GunungMenengah gunungMenengah1 = new GunungMenengah("Gunung Arjuno",
                "Malang, Mojokerto, Jawa Timur",
                "2-20 C","Gunung Arjuno adalah sebuah gunung berapi kerucut (istirahat) di Jawa Timur Gunung Arjuno adalah Gunung tertinggi ke-2 di Jawa Timur"
                ,"backpak, Jaket gunung, sarung tangan, kaus kaki, air minum dan snack"
                ,"2812 mdpl"
                ,"membutuhkan waktu rata-rata 1 hari untuk mencapai puncak tergantung rute yang digunakan terdapat 4 rute yang dapat dilewati dengan medan yang relatif mudah"
                ,"-Transport AC -Tiket masuk -makan 3x -tenda -2 porter"
                ,650000
                ,"http://bacaterus.net/wp-content/uploads/2016/11/gunung-arjuno.jpg");
        mGunungMenengahList.add(gunungMenengah1);
        GunungMenengah gunungMenengah2 = new GunungMenengah("Gunung Ijen",
                "Kabupaten Banyuwangi, Jawa Timur",
                "2-18 C","Gunung Ijen adalah sebuah gunung berapi aktif yang terletak di perbatasan antara Kabupaten Banyuwangi dan Kabupaten Bondowoso, Jawa Timur, Indonesia. Gunung ini memiliki ketinggian 2.443 mdpl dan terletak berdampingan dengan Gunung Merapi. Salah satu fenomena alam yang paling terkenal dari Gunung Ijen adalah kawah yang terletak di puncaknya. Pendakian gunung ini bisa dimulai dari beberapa tempat. Pendaki bisa berangkat dari Banyuwangi ataupun dari Bondowoso."
                ,"Daylyback + 40L backpak, Jaket gunung, sarung tangan, kaus kaki, sepatu anti selip"
                ,"2799 mdpl"
                ,"Jalan di sekitar kawah sangatlah curam, menanjak dan cukup licin, dengan melewati tepian hutan yang dapat dengan mudah diikuti. Perjalanan ini dapat ditempuh sekitar 90 menit. Waktu yang disarankan untuk berkunjung ke Kawah Ijen adalah sekitar April - Oktober, karena dalam waktu-waktu ini merupakan musim kemarau dan jalanan di sekitar lokasi tidak licin dan lebih aman."
                ,"-Transport AC -Tiket masuk dan retribusi kawah ijen -Akomodasi hotel 1 malam -air mineral 600ml -breakfast box 1x -guide lokal"
                ,600000
                ,"https://www.twisata.com/wp-content/uploads/2015/06/Kawah-Ijen-Jawa-Timur.jpg");
        mGunungMenengahList.add(gunungMenengah2);

        Adapter.notifyDataSetChanged();
    }
}
