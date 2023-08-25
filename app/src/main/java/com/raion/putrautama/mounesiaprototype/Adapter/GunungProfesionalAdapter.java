package com.raion.putrautama.mounesiaprototype.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.raion.putrautama.mounesiaprototype.DetailGunung.DetailGunungProfesionalActivity;
import com.raion.putrautama.mounesiaprototype.Model.GunungProfesional;
import com.raion.putrautama.mounesiaprototype.Model.Users;
import com.raion.putrautama.mounesiaprototype.R;

import java.util.List;

public class GunungProfesionalAdapter extends RecyclerView.Adapter<GunungProfesionalAdapter.GunungProfesionalViewHolder> {

    private List<GunungProfesional> gunungProfesionalList;
    private Context mContext;
    Users mUsers;

    public GunungProfesionalAdapter(List<GunungProfesional> gunungProfesionalList, Context mContext, Users mUsers) {
        this.gunungProfesionalList = gunungProfesionalList;
        this.mContext = mContext;
        this.mUsers = mUsers;
    }

    @Override
    public GunungProfesionalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gunung_profesional_list,parent,false);
        return new GunungProfesionalAdapter.GunungProfesionalViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(GunungProfesionalViewHolder holder,final int position) {
        final GunungProfesional gunungProfesional = gunungProfesionalList.get(position);
        holder.NamaGunungProfesional.setText(gunungProfesional.getNamaGunungProfesional());
        holder.LokasiGunungProfesional.setText(gunungProfesional.getLokasiGunungProfesional());
        holder.KetinggainGunungProfesional.setText(gunungProfesional.getKetinggianGunungProfesional());
        holder.SuhuGunungProfesional.setText(gunungProfesional.getSuhuGunungProfesional());


        Glide.with(mContext)
                .load(gunungProfesional.getFotoGunungProfesional())
                .into(holder.FotoGunungProfesional);

        holder.cardViewProfesional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(mContext, DetailGunungProfesionalActivity.class);
                intent.putExtra("GunungProfesional",gunungProfesionalList.get(position));
                intent.putExtra("USER", mUsers);

                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return gunungProfesionalList.size();
    }

    public class GunungProfesionalViewHolder extends RecyclerView.ViewHolder {
        public TextView NamaGunungProfesional, LokasiGunungProfesional, KetinggainGunungProfesional,SuhuGunungProfesional;
        public ImageView FotoGunungProfesional;
        public CardView cardViewProfesional;

        public GunungProfesionalViewHolder(View view) {
            super(view);
            NamaGunungProfesional = view.findViewById(R.id.namaGunungProfesional);
            LokasiGunungProfesional = view.findViewById(R.id.lokasiProfesional);
            KetinggainGunungProfesional = view.findViewById(R.id.ketinggianProfesional);
            SuhuGunungProfesional = view.findViewById(R.id.suhuProfesional);
            FotoGunungProfesional = view.findViewById(R.id.fotoGunungProfesional);
            cardViewProfesional = view.findViewById(R.id.cardViewProfesional);
        }
    }

}
