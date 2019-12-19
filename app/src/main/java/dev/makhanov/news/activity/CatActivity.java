package dev.makhanov.news.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import dev.makhanov.news.R;
import dev.makhanov.news.adapter.MatAdapter;
import dev.makhanov.news.adapter.press.IPressSearchItem;
import dev.makhanov.news.model.MatItem;

public class CatActivity extends AppCompatActivity implements IPressSearchItem {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_cat);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Тарих");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.list);
        List<MatItem> matItemList = new ArrayList<>();
        MatItem matItem1 = new MatItem();
        matItem1.setAuthor("Диляра Нурмуханова");
        matItem1.setDate("3 мин бурын");
        matItem1.setCat("Тарих");
        matItem1.setAuthorImage("https://s4.cdn.eg.ru/wp-content/uploads/2019/07/iris011245-632x474.jpg");
        matItem1.setBanner("https://e-history.kz/images/w800-h600-cct-si/media/upload/4624/2018/03/07/deb915831ddb248695b3c5c88dc9cb71.jpg");
        matItem1.setTitle("Томирис туралы кызыкты деректер");

        MatItem matItem2 = new MatItem();
        matItem2.setAuthor("Кики Мураталиев");
        matItem2.setDate("12 кантар 2019");
        matItem2.setCat("Тарих");
        matItem2.setAuthorImage("https://s4.cdn.eg.ru/wp-content/uploads/2019/07/iris011245-632x474.jpg");
        matItem2.setBanner("https://kazakh-tv.kz/photo/stories/148782521850c3cda.jpg");
        matItem2.setTitle("20 Бурын болган дастурлердин пайдасы");

        MatItem matItem3 = new MatItem();
        matItem3.setAuthor("Makhanov Madiyar");
        matItem3.setDate("12 кантар 2019");
        matItem3.setCat("Тарих");
        matItem3.setAuthorImage("https://s4.cdn.eg.ru/wp-content/uploads/2019/07/iris011245-632x474.jpg");
        matItem3.setBanner("https://e-history.kz/images/w800-h600-cct-si/media/upload/5129/2018/12/14/531688b8e9b8a5c8f40313a9921976e8.jpg");
        matItem3.setTitle("Томирис туралы кызыкты деректер");

        MatItem matItem4 = new MatItem();
        matItem4.setAuthor("Makhanov Madiyar");
        matItem4.setDate("12 кантар 2019");
        matItem4.setCat("Тарих");
        matItem4.setAuthorImage("https://s4.cdn.eg.ru/wp-content/uploads/2019/07/iris011245-632x474.jpg");
        matItem4.setBanner("https://sputniknews.kz/images/830/97/8309722.jpg");
        matItem4.setTitle("Томирис туралы кызыкты деректер");

        matItemList.add(matItem1);
        matItemList.add(matItem2);
        matItemList.add(matItem3);
        matItemList.add(matItem4);

        MatAdapter matAdapter = new MatAdapter(matItemList, this);
        recyclerView.setAdapter(matAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void clickedToOpen(int position) {
        Intent intent = new Intent(this, ContentActivity.class);
        startActivity(intent);
    }
}
