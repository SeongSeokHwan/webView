package com.example.webview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView; //바텀 네비게이션 뷰

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_nav);


        getSupportFragmentManager().beginTransaction().add(R.id.main_Frame, new Fragment_home()).commit();


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    //item을 클릭시 id값을 가져와 FrameLayout에 fragment.xml띄우기
                    case R.id.page_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_Frame, new Fragment_home()).commit();
                        break;
                    case R.id.page_people:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_Frame, new Fragment_people()).commit();
                        break;
                    case R.id.page_add:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_Frame, new Fragment_3()).commit();
                        break;
                    case R.id.page_board:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_Frame, new Fragment_Board()).commit();
                        break;
                }
                return true;
            }
        });
    }
}