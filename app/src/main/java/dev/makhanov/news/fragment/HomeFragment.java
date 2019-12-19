package dev.makhanov.news.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import java.util.ArrayList;
import java.util.List;

import dev.makhanov.news.R;
import dev.makhanov.news.activity.ContentActivity;
import dev.makhanov.news.adapter.HomeBannerAdapter;
import dev.makhanov.news.adapter.press.IPressHomeBanner;
import dev.makhanov.news.model.HomeBanner;

public class HomeFragment extends Fragment implements IPressHomeBanner {

    public HomeFragment() {
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.f_home, container, false);

        RecyclerView recyclerView = root.findViewById(R.id.list);
        SnapHelper helper = new LinearSnapHelper();
        recyclerView.setOnFlingListener(null);
        helper.attachToRecyclerView(recyclerView);
        List<HomeBanner> homeBanners = new ArrayList<>();
        HomeBanner test1 = new HomeBanner();

        test1.setAuthor("Askar Esentai");
        test1.setBannerTitle("Abay kara sozderi");
        test1.setBannerImage("https://ruh.kz/storage/6c/6c621a80d8c262f9c473e74df68f9023.jpg");
        test1.setAuthImage("https://img.tyt.by/n/lady.tut.by/0c/0/baby_face_01.jpg");

        HomeBanner test2 = new HomeBanner();
        test2.setAuthor("Askar Esentai");
        test2.setBannerTitle("Томирис");
        test2.setBannerImage("https://liter.kz/upload/resize_cache/iblock/218/1280_760_0/film-tomiris.JPG");
        test2.setAuthImage("https://img.tyt.by/n/lady.tut.by/0c/0/baby_face_01.jpg");

        homeBanners.add(test1);
        homeBanners.add(test2);


        HomeBannerAdapter adapter = new HomeBannerAdapter(homeBanners, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return root;
    }

    @Override
    public void clickedToOpen(int position) {
        Intent intent = new Intent(getContext(), ContentActivity.class);
        startActivity(intent);
    }
}
