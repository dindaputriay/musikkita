package com.java.fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bnvMusikKita;
    private FrameLayout flContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initview();

        bnvMusikKita.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_musik:
                        bukaFragment(new MusikFragment());
                        getSupportActionBar().setTitle("Musik");
                        return true;
                    case R.id.menu_album:
                        bukaFragment(new AlbumFragment());
                        getSupportActionBar().setTitle("Album");
                        return true;
                    case R.id.menu_artis:
                        bukaFragment(new ArtisFragment());
                        getSupportActionBar().setTitle("Artis");
                        return true;
                }
                return false;
            }
        });
    }

    private void initview() {
        bnvMusikKita = findViewById(R.id.bnv_musik_kita);
        flContainer = findViewById(R.id.ft_container);
        bukaFragment(new MusikFragment());
        getSupportActionBar().setTitle("Musik");
    }

    private void bukaFragment(Fragment frm){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
       ft.replace(R.id.ft_container, frm);
       ft.commit();
    }
}
