package dev.makhanov.news.adapter.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import dev.makhanov.news.R;
import dev.makhanov.news.adapter.press.IPressSearchItem;

public class RecomViewHolder extends RecyclerView.ViewHolder {
    public TextView title, category;
    public ImageView banner;
    public ConstraintLayout cont;

    public RecomViewHolder(@NonNull View itemView, IPressSearchItem iPressHomeBanner) {
        super(itemView);
        title = itemView.findViewById(R.id.title);
        banner = itemView.findViewById(R.id.image);
        category = itemView.findViewById(R.id.cat);
        cont = itemView.findViewById(R.id.cont);

        cont.setOnClickListener(v -> iPressHomeBanner.clickedToOpen(getAdapterPosition()));
    }
}