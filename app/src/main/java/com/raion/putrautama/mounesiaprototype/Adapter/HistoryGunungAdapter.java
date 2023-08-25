package com.raion.putrautama.mounesiaprototype.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.raion.putrautama.mounesiaprototype.Model.HistoryGunung;
import com.raion.putrautama.mounesiaprototype.R;

import java.util.List;

public class HistoryGunungAdapter extends RecyclerView.Adapter<HistoryGunungAdapter.HistoryGunungViewHolder> {

    private List<HistoryGunung> historyGunungList;
    private Context mContext;

    @Override
    public HistoryGunungViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.history_gunung_list,parent,false);
        return new HistoryGunungAdapter.HistoryGunungViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HistoryGunungViewHolder holder, int position) {
        HistoryGunung historyGunung = historyGunungList.get(position);
        holder.NamaGunung.setText(historyGunung.getNamaGunung());
        holder.LokasiGunung.setText(historyGunung.getLokasiGunung());
        holder.KetinggainGunung.setText(historyGunung.getKetinggianGunung());
        holder.SuhuGunung.setText(historyGunung.getSuhuGunung());


        Glide.with(mContext)
                .load(historyGunung.getFotoGunungProfesional())
                .into(holder.FotoGunung);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "berhasil", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return historyGunungList.size();
    }


    public class HistoryGunungViewHolder extends RecyclerView.ViewHolder {
        public TextView NamaGunung, LokasiGunung, KetinggainGunung,SuhuGunung;
        public ImageView FotoGunung;
        public CardView cardView;

        public HistoryGunungViewHolder(View view) {
            super(view);
            NamaGunung = view.findViewById(R.id.namaGunungHistory);
            LokasiGunung = view.findViewById(R.id.lokasiHistory);
            KetinggainGunung = view.findViewById(R.id.ketinggianHistory);
            SuhuGunung = view.findViewById(R.id.suhuHistory);
            FotoGunung = view.findViewById(R.id.fotoGunungHistory);
            cardView = view.findViewById(R.id.cardViewHistory);
        }
    }

    public HistoryGunungAdapter(List<HistoryGunung> historyGunungList, Context mContext) {
        this.historyGunungList = historyGunungList;
        this.mContext = mContext;
    }

}
