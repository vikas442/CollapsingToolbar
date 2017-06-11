package com.anton46.whatsapp_profile;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dHulk on 11/06/17.
 */

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    List<Flower> mFlowerList = new ArrayList<>();

    public CardAdapter(List<Flower> flowerList) {
        mFlowerList = flowerList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.Flower = getItem(position);
        holder.cardimage.setImageResource(holder.Flower.id);
        holder.cardtitle.setText(holder.Flower.name);
    }

    @Override
    public int getItemCount() {
        return mFlowerList.size();
    }

    public Flower getItem(int position) {
        return mFlowerList.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView cardimage;
        TextView cardtitle;
        Flower Flower;

        public ViewHolder(View itemView) {
            super(itemView);
            cardimage = (ImageView) itemView.findViewById(R.id.cardImage);
            cardtitle = (TextView) itemView.findViewById(R.id.cardTitle);
        }
    }
}
