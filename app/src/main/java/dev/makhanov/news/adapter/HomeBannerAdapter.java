package dev.makhanov.news.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import dev.makhanov.news.R;
import dev.makhanov.news.adapter.holder.HomeBannerViewHolder;
import dev.makhanov.news.adapter.press.IPressHomeBanner;
import dev.makhanov.news.model.HomeBanner;

public class HomeBannerAdapter extends RecyclerView.Adapter<HomeBannerViewHolder> {
    private List<HomeBanner> homeBanners;
    private IPressHomeBanner iPressHomeBanner;

    public HomeBannerAdapter(List<HomeBanner> homeBanners, IPressHomeBanner iPressHomeBanner) {
        this.homeBanners = homeBanners;
        this.iPressHomeBanner = iPressHomeBanner;
    }

    @NonNull
    @Override
    public HomeBannerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.i_banner, parent, false);
        return new HomeBannerViewHolder(view, iPressHomeBanner);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeBannerViewHolder holder, int position) {
        holder.title.setText(homeBanners.get(position).getBannerTitle());
        holder.author.setText(homeBanners.get(position).getAuthor());

        Picasso.get()
                .load(homeBanners.get(position).getBannerImage())
                .fit()
                .centerCrop()
                .into(holder.banner);

        Picasso.get()
                .load(homeBanners.get(position).getAuthImage())
                .fit()
                .centerCrop()
                .into(holder.authorImage);
    }

    @Override
    public int getItemCount() {
        return homeBanners.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}