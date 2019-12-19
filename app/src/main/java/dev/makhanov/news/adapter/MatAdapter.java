package dev.makhanov.news.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import dev.makhanov.news.R;
import dev.makhanov.news.adapter.holder.MatViewHolder;
import dev.makhanov.news.adapter.press.IPressSearchItem;
import dev.makhanov.news.model.MatItem;

public class MatAdapter extends RecyclerView.Adapter<MatViewHolder> {
    private List<MatItem> matItemList;
    private IPressSearchItem iPressSearchItem;

    public MatAdapter(List<MatItem> matItemList, IPressSearchItem iPressSearchItem) {
        this.matItemList = matItemList;
        this.iPressSearchItem = iPressSearchItem;
    }

    @NonNull
    @Override
    public MatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.i_list, parent, false);
        return new MatViewHolder(view, iPressSearchItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MatViewHolder holder, int position) {
        holder.title.setText(matItemList.get(position).getTitle());
        holder.category.setText(matItemList.get(position).getCat());
        holder.date.setText(matItemList.get(position).getDate());
        holder.author.setText(matItemList.get(position).getAuthor());

        Picasso.get()
                .load(matItemList.get(position).getBanner())
                .fit()
                .centerCrop()
                .into(holder.banner);

        Picasso.get()
                .load(matItemList.get(position).getAuthorImage())
                .fit()
                .centerCrop()
                .into(holder.authorImage);
    }

    @Override
    public int getItemCount() {
        return matItemList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}