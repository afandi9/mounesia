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
import com.raion.putrautama.mounesiaprototype.DetailGunung.DetailGunungPemulaActivity;
import com.raion.putrautama.mounesiaprototype.Model.GunungPemula;
import com.raion.putrautama.mounesiaprototype.Model.Users;
import com.raion.putrautama.mounesiaprototype.R;

import java.util.List;

public class GunungPemulaAdapter extends RecyclerView.Adapter<GunungPemulaAdapter.GunungPemulaViewHolder> {

    private List<GunungPemula> gunungPemulaList;
    private Context mContext;
    Users mUsers;

    public GunungPemulaAdapter(List<GunungPemula> gunungPemulaList, Context mContext, Users mUsers) {
        this.gunungPemulaList = gunungPemulaList;
        this.mContext = mContext;
        this.mUsers = mUsers;
    }

    @Override
    public GunungPemulaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gunung_pemula_list,parent,false);
        return new GunungPemulaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(GunungPemulaViewHolder holder, final int position) {
        final GunungPemula gunungPemula =gunungPemulaList.get(position);
        holder.NamaGunungPemula.setText(gunungPemula.getNamaGunungPemula());
        holder.LokasiGunungPemula.setText(gunungPemula.getLokasiGunungPemula());
        holder.KetinggainGunungPemula.setText(gunungPemula.getKetinggianGunungPemula());
        holder.SuhuGunungPemula.setText(gunungPemula.getSuhuGunungPemula());


        Glide.with(mContext)
                .load(gunungPemula.getFotoGunungPemula())
                .into(holder.FotoGunungPemula);

        holder.cardViewPemula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(mContext, DetailGunungPemulaActivity.class);
                intent.putExtra("GunungPemula",gunungPemulaList.get(position));
                intent.putExtra("USER", mUsers);

                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return gunungPemulaList.size();
    }


    public class GunungPemulaViewHolder extends RecyclerView.ViewHolder {
        public TextView NamaGunungPemula, LokasiGunungPemula, KetinggainGunungPemula,SuhuGunungPemula;
        public ImageView FotoGunungPemula;
        public CardView cardViewPemula;

        public GunungPemulaViewHolder(View view) {
            super(view);
            NamaGunungPemula = view.findViewById(R.id.namaGunungpemula);
            LokasiGunungPemula = view.findViewById(R.id.lokasipemula);
            KetinggainGunungPemula = view.findViewById(R.id.ketinggianpemula);
            SuhuGunungPemula = view.findViewById(R.id.suhupemula);
            FotoGunungPemula = view.findViewById(R.id.fotoGunungPemula);
            cardViewPemula = view.findViewById(R.id.cardViewPemula);
        }
    }


}
