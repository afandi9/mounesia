package com.raion.putrautama.mounesiaprototype;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.raion.putrautama.mounesiaprototype.Gunung.GunungMenengahActivity;
import com.raion.putrautama.mounesiaprototype.Gunung.GunungPemulaActivity;
import com.raion.putrautama.mounesiaprototype.Model.Users;
import com.raion.putrautama.mounesiaprototype.Soal.SoalMenengahActivity;
import com.raion.putrautama.mounesiaprototype.Soal.SoalPemulaActivity;
import com.raion.putrautama.mounesiaprototype.Soal.SoalProfesionalActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    Button mPemula,mMenengah,mProfesional;
    private static final String TAG = "ViewDatabase";
    public HomeFragment() {
        // Required empty public constructor
    }

    Users mUsers;
    FirebaseDatabase database;
    DatabaseReference myRef;
    private Long NilaiPemula;
    private Long NilaiMenengah;
    private Long NilaiProfesional;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mUsers = (Users) getArguments().getSerializable("USER");
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPemula = view.findViewById(R.id.pemula);
        mMenengah = view.findViewById(R.id.menengah);
        mProfesional = view.findViewById(R.id.profesional);


//        fetchDataPemula();
//        fetchDataMenengah();
//        fetchDataProfesional();
        Pemula();
        Menengah();
        Profesioanal();
    }
    public void Pemula(){
        mPemula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (NilaiPemula == null){
                    Intent intent = new Intent(getActivity(), SoalPemulaActivity.class);
                    intent.putExtra("USER", mUsers);
                    startActivity(intent);
                }else{
                    fetchDataPemula();
                    if (NilaiPemula >= 6){
                        Intent intent = new Intent(getActivity(), GunungPemulaActivity.class);
                        intent.putExtra("USER", mUsers);
                        startActivity(intent);
                    }else if (NilaiPemula < 6){
                        Intent intent = new Intent(getActivity(), SoalPemulaActivity.class);
                        intent.putExtra("USER", mUsers);
                        startActivity(intent);
                    }
                }

            }
        });
    }
    public void Menengah(){
        mMenengah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (NilaiMenengah == null){
                    Intent intent = new Intent(getActivity(), SoalMenengahActivity.class);
                    intent.putExtra("USER", mUsers);
                    startActivity(intent);
                }else{
                    fetchDataMenengah();
                    if (NilaiMenengah >= 6){
                        Intent intent = new Intent(getActivity(), GunungMenengahActivity.class);
                        intent.putExtra("USER", mUsers);
                        startActivity(intent);
                    }else if (NilaiMenengah < 6){
                        Intent intent = new Intent(getActivity(), SoalMenengahActivity.class);
                        intent.putExtra("USER", mUsers);
                        startActivity(intent);
                    }
                }
            }
        });
    }
    public void Profesioanal(){
        mProfesional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (NilaiProfesional == null){
                    Intent intent = new Intent(getActivity(), SoalProfesionalActivity.class);
                    intent.putExtra("USER", mUsers);
                    startActivity(intent);
                }else {
                    fetchDataProfesional();
                    if (NilaiProfesional >= 6){
                        Intent intent = new Intent(getActivity(), GunungMenengahActivity.class);
                        intent.putExtra("USER", mUsers);
                        startActivity(intent);
                    }else if (NilaiProfesional < 6){
                        Intent intent = new Intent(getActivity(), SoalProfesionalActivity.class);
                        intent.putExtra("USER", mUsers);
                        startActivity(intent);
                    }
                }

            }
        });
    }

    private void fetchDataPemula() {
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Users");

        myRef.child(mUsers.getUniqueId()).child("nilaiPemula").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot userDataSnapshot: dataSnapshot.getChildren()) {
                    NilaiPemula = userDataSnapshot.getValue(Long.class);

                    Log.d(TAG, "onDataChange:" + NilaiPemula);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void fetchDataMenengah() {
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Users");

        myRef.child(mUsers.getUniqueId()).child("nilaiMenengah").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot userDataSnapshot: dataSnapshot.getChildren()) {
                    NilaiMenengah = userDataSnapshot.getValue(Long.class);

                    Log.d(TAG, "onDataChange:" + NilaiMenengah);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void fetchDataProfesional() {
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Users");

        myRef.child(mUsers.getUniqueId()).child("nilaiProfesional").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot userDataSnapshot: dataSnapshot.getChildren()) {

                    NilaiProfesional = userDataSnapshot.getValue(Long.class);

                    Log.d(TAG, "onDataChange:" + NilaiProfesional);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
