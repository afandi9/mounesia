package com.raion.putrautama.mounesiaprototype;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.raion.putrautama.mounesiaprototype.Model.Users;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends Fragment {

Button mSetting;
    Users mUsers;
    EditText mNama,mNotlp;
    FirebaseDatabase database;
    DatabaseReference myRef;
    String namaLengkap, noTlp;
    public SettingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mUsers = (Users) getArguments().getSerializable("USER");
        return inflater.inflate(R.layout.fragment_setting, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mNama = view.findViewById(R.id.namaUser);
        mNotlp = view.findViewById(R.id.notlpUser);
        mSetting = view.findViewById(R.id.btnSetting);
        mSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 namaLengkap  = mNama.getText().toString();
                 noTlp = mNotlp.getText().toString();
                database = FirebaseDatabase.getInstance();
                myRef = database.getReference("Users");
                myRef.child(mUsers.getUniqueId()).child("namaLengkap").setValue(namaLengkap);
                myRef.child(mUsers.getUniqueId()).child("noTlp").setValue(noTlp);
                swapFragment();
            }
        });
    }

    private void swapFragment(){
//        writeToDatabase(namaLengkap,noTlp);
        ProfileFragment fragment = new ProfileFragment();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putSerializable("USER", mUsers);
        fragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    public void writeToDatabase(String namalengkap,
                                String notlp ){
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Users");
        myRef.child(mUsers.getUniqueId()).child("namaLengkap").setValue(namalengkap);
        myRef.child(mUsers.getUniqueId()).child("noTlp").setValue(notlp);


    }
}
