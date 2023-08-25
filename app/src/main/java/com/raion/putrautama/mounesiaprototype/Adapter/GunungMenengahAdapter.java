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
import com.raion.putrautama.mounesiaprototype.DetailGunung.DetailGunungMenengahActivity;
import com.raion.putrautama.mounesiaprototype.Model.GunungMenengah;
import com.raion.putrautama.mounesiaprototype.Model.Users;
import com.raion.putrautama.mounesiaprototype.R;

import java.util.List;

public class GunungMenengahAdapter extends RecyclerView.Adapter<GunungMenengahAdapter.GunungMenengahViewHolder> {

    private List<GunungMenengah> gunungMenengahList;
    private Context mContext;
    Users mUsers;

    public GunungMenengahAdapter(List<GunungMenengah> gunungMenengahList, Context mContext, Users mUsers) {
        this.gunungMenengahList = gunungMenengahList;
        this.mContext = mContext;
        this.mUsers = mUsers;
    }

    @Override
    public GunungMenengahViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gunung_menengah_list,parent,false);
        return new GunungMenengahAdapter.GunungMenengahViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(GunungMenengahViewHolder holder, final int position) {
        final GunungMenengah gunungMenengah = gunungMenengahList.get(position);
        holder.NamaGunungMenengah.setText(gunungMenengah.getNamaGunungMenengah());
        holder.LokasiGunungMenengah.setText(gunungMenengah.getLokasiGunungMenengah());
        holder.KetinggainGunungMenengah.setText(gunungMenengah.getKetinggianGunungMenengah());
        holder.SuhuGunungMenengah.setText(gunungMenengah.getSuhuGunungMenengah());


        Glide.with(mContext)
                .load(gunungMenengah.getFotoGunungMenengah())
                .into(holder.FotoGunungMenengah);

        holder.cardViewMenengah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(mContext, DetailGunungMenengahActivity.class);
                intent.putExtra("GunungMenengah",gunungMenengahList.get(position));
                intent.putExtra("USER", mUsers);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return gunungMenengahList.size();
    }

    public class GunungMenengahViewHolder extends RecyclerView.ViewHolder {
        public TextView NamaGunungMenengah, LokasiGunungMenengah, KetinggainGunungMenengah,SuhuGunungMenengah;
        public ImageView FotoGunungMenengah;
        public CardView cardViewMenengah;

        public GunungMenengahViewHolder(View view) {
            super(view);
            NamaGunungMenengah = view.findViewById(R.id.namaGunungMenengah);
            LokasiGunungMenengah = view.findViewById(R.id.lokasiMenengah);
            KetinggainGunungMenengah = view.findViewById(R.id.ketinggianMenengah);
            SuhuGunungMenengah = view.findViewById(R.id.suhuMenengah);
            FotoGunungMenengah = view.findViewById(R.id.fotoGunungMenengah);
            cardViewMenengah = view.findViewById(R.id.cardViewMenengah);
        }
    }

}
