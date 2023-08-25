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
import com.raion.putrautama.mounesiaprototype.Model.GunungMenengah;
import com.raion.putrautama.mounesiaprototype.Model.GunungPemula;
import com.raion.putrautama.mounesiaprototype.Model.Pesanan;
import com.raion.putrautama.mounesiaprototype.Model.Users;
import com.raion.putrautama.mounesiaprototype.R;

import java.util.List;

public class PesananAdapter extends RecyclerView.Adapter<PesananAdapter.PesananViewHolder> {
    private List<Pesanan> pesanans;
    private Context mContext;

    public PesananAdapter(List<Pesanan> pesanans, Context mContext) {
        this.pesanans = pesanans;
        this.mContext = mContext;
    }

    @Override
    public PesananAdapter.PesananViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.history_gunung_list,parent,false);
        return new PesananAdapter.PesananViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PesananAdapter.PesananViewHolder holder, int position) {
        final Pesanan pesanan =pesanans.get(position);
        holder.NamaGunung.setText(pesanan.getNamaGunung());
        holder.LokasiGunung.setText(pesanan.getLokasiGunung());
        holder.KetinggainGunung.setText(pesanan.getKetinggianGunung());
        holder.SuhuGunung.setText(pesanan.getSuhuGunung());


        Glide.with(mContext)
                .load(pesanan.getFotoGunung())
                .into(holder.FotoGunung);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, pesanan.getNamaGunung(), Toast.LENGTH_SHORT).show();
//
//                Intent intent = new Intent(mContext, DetailGunungPemulaActivity.class);
//                intent.putExtra("PESANAN",gunungPemulaList.get(position));
//                intent.putExtra("USER", mUsers);
//
//                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pesanans.size();
    }

    public class PesananViewHolder extends RecyclerView.ViewHolder {

        public TextView NamaGunung, LokasiGunung, KetinggainGunung,SuhuGunung;
        public ImageView FotoGunung;
        public CardView cardView;


        public PesananViewHolder(View itemView) {
            super(itemView);

            NamaGunung = itemView.findViewById(R.id.namaGunungHistory);
            LokasiGunung = itemView.findViewById(R.id.lokasiHistory);
            KetinggainGunung = itemView.findViewById(R.id.ketinggianHistory);
            SuhuGunung = itemView.findViewById(R.id.suhuHistory);
            FotoGunung = itemView.findViewById(R.id.fotoGunungHistory);
            cardView = itemView.findViewById(R.id.cardViewHistory);
        }
    }
}
