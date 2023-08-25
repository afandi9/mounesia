package com.raion.putrautama.mounesiaprototype;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.raion.putrautama.mounesiaprototype.Model.Users;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    public Button mLogout;
    public TextView mNama,mEmail,mUsername,mNohp;
    public ImageView mMenu;

    Users mUsers;
    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mUsers = (Users) getArguments().getSerializable("USER");
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mMenu = view.findViewById(R.id.menu);
        mMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapFragment();
            }
        });

        mNama = view.findViewById(R.id.namaLengkap);
        mEmail = view.findViewById(R.id.email);
        mUsername = view.findViewById(R.id.username);
        mNohp = view.findViewById(R.id.noHp);
        mLogout = view.findViewById(R.id.btnLogout);
        mLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

        mNama.setText(mUsers.getNamaLengkap());
        mEmail.setText(mUsers.getEmail());
        mUsername.setText(mUsers.getUsername());
        mNohp.setText(mUsers.getNoTlp());

    }
    private void swapFragment(){
        SettingFragment fragment = new SettingFragment();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putSerializable("USER", mUsers);
        fragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
