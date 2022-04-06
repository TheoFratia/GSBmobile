package com.example.gsb_frais;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class GsbRvVisitesAdapter extends RecyclerView.Adapter<GsbRvVisitesAdapter.ViewHolder>  {
    private ArrayList<Visites> dateModelList;


    public GsbRvVisitesAdapter(ArrayList<Visites> dateModelList) {
        this.dateModelList = dateModelList;
    }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder viewHolder;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items_visites, parent, false);
        viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.date_visite.setText(String.valueOf(dateModelList.get(position).getDate()));
        holder.commentaire.setText(String.valueOf(dateModelList.get(position).getCommentaire()));
        holder.motif.setText(String.valueOf(dateModelList.get(position).getMotif()));
    }

    @Override
    public int getItemCount() {

        return dateModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView date_visite, commentaire, motif;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            date_visite = itemView.findViewById(R.id.dateVisites);
            commentaire = itemView.findViewById(R.id.commentaire);
            motif = itemView.findViewById(R.id.motif);
        }
    }
}
