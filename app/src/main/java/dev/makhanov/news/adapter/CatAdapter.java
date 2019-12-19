package dev.makhanov.news.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import dev.makhanov.news.R;
import dev.makhanov.news.adapter.holder.CatViewHolder;
import dev.makhanov.news.adapter.press.IPressSearchItem;
import dev.makhanov.news.model.Category;

public class CatAdapter extends RecyclerView.Adapter<CatViewHolder> {
    private List<Category> categoryList;
    private IPressSearchItem iPressSearchItem;

    public CatAdapter(List<Category> categoryList, IPressSearchItem iPressSearchItem) {
        this.categoryList = categoryList;
        this.iPressSearchItem = iPressSearchItem;
    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.i_cat, parent, false);
        return new CatViewHolder(view, iPressSearchItem);
    }

    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, int position) {
        holder.title.setText(categoryList.get(position).getTitle());

        Picasso.get()
                .load(categoryList.get(position).getBanner())
                .fit()
                .centerCrop()
                .into(holder.banner);
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}