package dev.makhanov.news.adapter.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import dev.makhanov.news.R;
import dev.makhanov.news.adapter.press.IPressSearchItem;

public class MatViewHolder extends RecyclerView.ViewHolder {
    public TextView title, category, date, author;
    public ImageView banner, authorImage;
    public ConstraintLayout cont;

    public MatViewHolder(@NonNull View itemView, IPressSearchItem iPressHomeBanner) {
        super(itemView);
        title = itemView.findViewById(R.id.title);
        banner = itemView.findViewById(R.id.image);
        cont = itemView.findViewById(R.id.cont);
        category = itemView.findViewById(R.id.cat);
        date = itemView.findViewById(R.id.date);
        author = itemView.findViewById(R.id.author);
        authorImage = itemView.findViewById(R.id.author_image);

        cont.setOnClickListener(v -> iPressHomeBanner.clickedToOpen(getAdapterPosition()));
    }
}