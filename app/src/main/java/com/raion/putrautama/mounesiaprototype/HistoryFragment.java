package com.raion.putrautama.mounesiaprototype;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.raion.putrautama.mounesiaprototype.Adapter.HistoryGunungAdapter;
import com.raion.putrautama.mounesiaprototype.Adapter.PesananAdapter;
import com.raion.putrautama.mounesiaprototype.Model.HistoryGunung;
import com.raion.putrautama.mounesiaprototype.Model.Pesanan;
import com.raion.putrautama.mounesiaprototype.Model.Users;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private PesananAdapter Adapter;
    private List<Pesanan> pesananList;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    Users mUsers;
    public HistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView = view.findViewById(R.id.recycler_viewHistory);
        mUsers = (Users) getArguments().getSerializable("USER");
        pesananList = new ArrayList<>();
        fetchData();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));


//        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 1);
//        mRecyclerView.setLayoutManager(mLayoutManager);
//        mRecyclerView.setAdapter(Adapter);

//        preaperedGunung();

    }
    private void fetchData() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Users");

        databaseReference.child(mUsers.getUniqueId()).child("pesanan").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot tiapDataSnapshot:dataSnapshot.getChildren()) {
                    Pesanan pesanan = tiapDataSnapshot.getValue(Pesanan.class);
                    pesananList.add(pesanan);
                }
                loadRecyclerViewNotifikasi();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    private void loadRecyclerViewNotifikasi() {
        //you can fetch the data from server or some apis
        //for this tutorial I am adding some dummy data directly
        Adapter = new PesananAdapter(pesananList,getActivity());
        Adapter.notifyDataSetChanged();
        mRecyclerView.setAdapter(Adapter);


    }
//    private void preaperedGunung(){
//        int [] fotoGunungHistory = new int[]{
//                R.mipmap.arjuno,
//                R.mipmap.ijen,
//                R.mipmap.bromo
//        };
//
//        HistoryGunung historyGunung1 = new HistoryGunung("Gunung Arjuno",
//                "Malang, Mojokerto, Jawa Timur","2812 mdpl"
//                ,"2-20 C",fotoGunungHistory[0]);
//        mHistoryGunungList.add(historyGunung1);
//        HistoryGunung historyGunung2 = new HistoryGunung("Gunung Ijen",
//                "Kabupaten Banyuwangi, Jawa Timur","2799 mdpl"
//                ,"2-18 C",fotoGunungHistory[1]);
//        mHistoryGunungList.add(historyGunung2);
//
//        HistoryGunung historyGunung3 = new HistoryGunung("Gunung Bromo",
//                "Tosari, Pasuruan, Jawa Timur","2329 mdpl"
//                ,"3-22 C",fotoGunungHistory[2]);
//        mHistoryGunungList.add(historyGunung3);
//
//        Adapter.notifyDataSetChanged();
//    }
}
