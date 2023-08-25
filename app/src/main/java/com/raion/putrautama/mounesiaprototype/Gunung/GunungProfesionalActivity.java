package com.raion.putrautama.mounesiaprototype.Gunung;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.raion.putrautama.mounesiaprototype.Adapter.GunungProfesionalAdapter;
import com.raion.putrautama.mounesiaprototype.MainActivity;
import com.raion.putrautama.mounesiaprototype.Model.GunungProfesional;
import com.raion.putrautama.mounesiaprototype.Model.Users;
import com.raion.putrautama.mounesiaprototype.R;

import java.util.ArrayList;
import java.util.List;

public class GunungProfesionalActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private GunungProfesionalAdapter Adapter;
    private List<GunungProfesional> mGunungProfesionalList;

    ImageView mBack;
    Users mUsers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gunung_profesional);

        mUsers = (Users) getIntent().getSerializableExtra("USER");


        mBack = findViewById(R.id.back);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(GunungProfesionalActivity.this,MainActivity.class);
                intent.putExtra("USER", mUsers);
                startActivity(intent);
            }
        });

        mRecyclerView = findViewById(R.id.recycler_viewProfesional);
        mGunungProfesionalList = new ArrayList<>();
        Adapter = new GunungProfesionalAdapter(mGunungProfesionalList, this,mUsers);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(Adapter);

        preaperedGunung();
    }

    private void preaperedGunung(){
//        int [] fotoGunungPemula = new int[]{
//                R.mipmap.argopuro,
//                R.mipmap.raung
//        };

        GunungProfesional gunungProfesional1 = new GunungProfesional("Gunung Argopuro",
                "Banyuwangi, Bondowoso, Jember, Jawa Timur",
                "5-15 C"
                ,"Gunung Argopuro adalah sebuah gunung berapi kompleks yang terdapat di Jawa Timur. Merupakan puncak tertinggi dari Pegunungan Iyang serta berada pada posisi di antara Gunung Semeru dan Gunung Raung.Gunung Argopuro mempunyai kawasan hutan Dipterokarp Bukit, hutan Dipterokarp Atas, hutan Montane, dan Hutan Ericaceous atau hutan gunung. Merupakan gunung dengan trek terpanjang di jawa"
                ,"60L backpak, tenda, sleeping bag, Jaket gunung, sarung tangan, kaus kaki, sepatu anti selip"
                ,"3344 mdpl"
                ,"membutuhkan waktu 3-6 hari untuk mencapai puncak karena rute yang berbeda-beda. Jalan untuk menuju danau sudah baik tanpa persimpangan, namun untuk mencapai puncak membutuhkan kondisi fisik yang baik dan jalanan cukup ekstrim"
                ," -Transport selama trip -makan selama pendakian -tenda -sleeping bag -p3k -guide dan porter"
                ,1700000,"http://gunung.id/wp-content/uploads/2017/10/Estimasi-pendakian-gunung-argopuro.jpg");
        mGunungProfesionalList.add(gunungProfesional1);
        GunungProfesional gunungProfesional2 = new GunungProfesional("Gunung Raung",
                "Banyuwangi, Bondowoso, Jember, Jawa Timur",
                "4-20 C",
                "Gunung Raung merupakan gunung tertinggi kedua di Jawa Timur setelah Gunung Semeru, serta menjadi yang tertinggi keempat di Pulau Jawa. Merupakan gunung dengan rute menuju puncak terektrim di jawa timur"
                ,"40L backpak, peralatan mendaki, tenda, sleeping bag, Jaket gunung, sarung tangan, kaus kaki, sepatu anti selip"
                ,"3344 mdpl"
                ,"membutuhkan waktu 7 hari untuk mencapai puncak. Rute perjalanan cukup ekstrim dengan melalui banyak tanjakan terjal."
                ," -transportasi ojek -guide -alat panjat -rumah singgah"
                ,550000,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT9hOYED-cdOMe9JRbo4Vo3fx3E7rSrMaRklRnTtWaeqK29tAJSqQ");
        mGunungProfesionalList.add(gunungProfesional2);

        Adapter.notifyDataSetChanged();
    }
}
