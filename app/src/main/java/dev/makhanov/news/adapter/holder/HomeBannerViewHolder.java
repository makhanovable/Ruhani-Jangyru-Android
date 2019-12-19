package dev.makhanov.news.adapter.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import dev.makhanov.news.R;
import dev.makhanov.news.adapter.press.IPressHomeBanner;

public class HomeBannerViewHolder extends RecyclerView.ViewHolder {
    public TextView title, author;
    public ImageView banner, authorImage;
    public FloatingActionButton ok;

    public HomeBannerViewHolder(@NonNull View itemView, IPressHomeBanner iPressHomeBanner) {
        super(itemView);
        title = itemView.findViewById(R.id.title);
        author = itemView.findViewById(R.id.author);
        banner = itemView.findViewById(R.id.image);
        authorImage = itemView.findViewById(R.id.author_image);
        ok = itemView.findViewById(R.id.ok);

        ok.setOnClickListener(v -> iPressHomeBanner.clickedToOpen(getAdapterPosition()));
    }
}