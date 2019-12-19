package dev.makhanov.news.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import java.util.ArrayList;
import java.util.List;

import dev.makhanov.news.R;
import dev.makhanov.news.activity.CatActivity;
import dev.makhanov.news.adapter.CatAdapter;
import dev.makhanov.news.adapter.RecomAdapter;
import dev.makhanov.news.adapter.press.IPressSearchItem;
import dev.makhanov.news.model.Category;

public class SearchFragment extends Fragment implements IPressSearchItem {

    public SearchFragment() {
    }

    public static SearchFragment newInstance() {
        return new SearchFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.f_search, container, false);

        RecyclerView list1 = root.findViewById(R.id.list_1);
        List<Category> categoryList1 = new ArrayList<>();

        Category cat1 = new Category();
        cat1.setTitle("Шын Маншук");
        cat1.setCategory("Тарих");
        cat1.setBanner("https://www.syl.ru/misc/i/ai/318579/1812349.jpg");

        Category cat2 = new Category();
        cat2.setTitle("Шын Маншук");
        cat2.setCategory("Тарих");
        cat2.setBanner("https://www.syl.ru/misc/i/ai/318579/1812349.jpg");

        Category cat3 = new Category();
        cat3.setTitle("Шын Маншук");
        cat3.setCategory("Тарих");
        cat3.setBanner("https://www.syl.ru/misc/i/ai/318579/1812349.jpg");

        Category cat4 = new Category();
        cat4.setTitle("Шын Маншук");
        cat4.setCategory("Тарих");
        cat4.setBanner("https://www.syl.ru/misc/i/ai/318579/1812349.jpg");

        categoryList1.add(cat1);
        categoryList1.add(cat2);
        categoryList1.add(cat3);
        categoryList1.add(cat4);

        RecomAdapter recomAdapter = new RecomAdapter(categoryList1, this);
        list1.setAdapter(recomAdapter);
        list1.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        SnapHelper helper = new LinearSnapHelper();
        list1.setOnFlingListener(null);
        helper.attachToRecyclerView(list1);


        RecyclerView list2 = root.findViewById(R.id.list_2);

        List<Category> categoryList2 = new ArrayList<>();

        Category cat5 = new Category();
        cat5.setTitle("Тарих");
        cat5.setBanner("https://www.syl.ru/misc/i/ai/318579/1812349.jpg");

        Category cat6 = new Category();
        cat6.setTitle("Гылым");
        cat6.setBanner("https://www.syl.ru/misc/i/ai/318579/1812349.jpg");

        Category cat7 = new Category();
        cat7.setTitle("Мадениет");
        cat7.setBanner("https://www.syl.ru/misc/i/ai/318579/1812349.jpg");

        Category cat8 = new Category();
        cat8.setTitle("Отбасы");
        cat8.setBanner("https://www.syl.ru/misc/i/ai/318579/1812349.jpg");

        Category cat9 = new Category();
        cat9.setTitle("Психология");
        cat9.setBanner("https://www.syl.ru/misc/i/ai/318579/1812349.jpg");

        categoryList2.add(cat5);
        categoryList2.add(cat6);
        categoryList2.add(cat7);
        categoryList2.add(cat8);
        categoryList2.add(cat9);

        CatAdapter catAdapter = new CatAdapter(categoryList2, this);
        list2.setAdapter(catAdapter);
        list2.setLayoutManager(new GridLayoutManager(getContext(), 2));

        return root;
    }

    @Override
    public void clickedToOpen(int position) {
        Intent intent = new Intent(getContext(), CatActivity.class);
        startActivity(intent);
    }
}
