package dev.makhanov.news.activity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import dev.makhanov.news.R;
import dev.makhanov.news.fragment.AuthFragment;
import dev.makhanov.news.fragment.HomeFragment;
import dev.makhanov.news.fragment.SavedFragment;
import dev.makhanov.news.fragment.SearchFragment;
import dev.makhanov.news.util.ConstantUtil;

public class MainActivity extends AppCompatActivity {
    private HomeFragment homeFragment = HomeFragment.newInstance();
    private SearchFragment searchFragment = SearchFragment.newInstance();
    private SavedFragment savedFragment = SavedFragment.newInstance();
    private AuthFragment authFragment = AuthFragment.newInstance();

    private BottomNavigationView bottomMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_main);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        final int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

        getWindow().getDecorView().setSystemUiVisibility(flags);

        final View decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(visibility -> {
            if ((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0) {
                decorView.setSystemUiVisibility(flags);
            }
        });

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction
                .add(R.id.frame, homeFragment)
                .add(R.id.frame, searchFragment)
                .add(R.id.frame, savedFragment)
                .add(R.id.frame, authFragment)
                .commit();

        String tag = "home";
        if (getIntent() != null && getIntent().getExtras() != null) {
            tag = getIntent().getExtras().getString("tag", "home");
        }

        bottomMenu = findViewById(R.id.bottom_menu);
        bottomMenu.setOnNavigationItemSelectedListener(menuItem -> {
            ConstantUtil.hideSoftKeyboard(this);
            switch (menuItem.getItemId()) {
                case R.id.home:
                    loadFragment("home", false);
                    break;
                case R.id.search:
                    loadFragment("search", false);
                    break;
                case R.id.saved:
                    loadFragment("saved", false);
                    break;
                case R.id.auth:
                    loadFragment("auth", false);
                    break;
            }
            return true;
        });

        loadFragment(tag, true);
    }

    private void loadFragment(String tag, boolean yes) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        switch (tag) {
            case "home":
                if (yes)
                    bottomMenu.setSelectedItemId(R.id.home);
                transaction.show(homeFragment);
                transaction.hide(searchFragment);
                transaction.hide(savedFragment);
                transaction.hide(authFragment);
                break;
            case "search":
                if (yes)
                    bottomMenu.setSelectedItemId(R.id.search);
                transaction.show(searchFragment);
                transaction.hide(homeFragment);
                transaction.hide(savedFragment);
                transaction.hide(authFragment);
                break;
            case "saved":
                if (yes)
                    bottomMenu.setSelectedItemId(R.id.saved);
                transaction.show(savedFragment);
                transaction.hide(homeFragment);
                transaction.hide(searchFragment);
                transaction.hide(authFragment);
                break;
            case "auth":
                if (yes)
                    bottomMenu.setSelectedItemId(R.id.auth);
                transaction.show(authFragment);
                transaction.hide(homeFragment);
                transaction.hide(searchFragment);
                transaction.hide(savedFragment);
                break;
        }
        transaction.commit();
    }

    @Override
    protected void onResume() {
        ConstantUtil.hideSoftKeyboard(this);
        super.onResume();
    }

}