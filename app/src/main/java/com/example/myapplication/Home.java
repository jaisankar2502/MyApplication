package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Fragment;
import android.os.Bundle;

import com.example.myapplication.adapter.FragmentAdapter;
import com.google.android.material.tabs.TabLayout;

public class Home extends AppCompatActivity {
    ViewPager2 pager2;
    TabLayout tabLayout;
    FragmentAdapter fragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tabLayout= findViewById(R.id.HomeTabid);
        pager2= findViewById(R.id.HomeViewPager);

        FragmentManager fm= getSupportFragmentManager();
        fragmentAdapter= new FragmentAdapter(fm,getLifecycle());
        pager2.setAdapter(fragmentAdapter);


        // creating tabs
        tabLayout.addTab(tabLayout.newTab().setText("Profile").setIcon(R.drawable.ic_profile));
        tabLayout.addTab(tabLayout.newTab().setText("Certificate").setIcon(R.drawable.ic_certificate));
        tabLayout.addTab(tabLayout.newTab().setText("Chat").setIcon(R.drawable.ic_score));
        tabLayout.addTab(tabLayout.newTab().setText("Score").setIcon(R.drawable.ic_chat));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        pager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });
    }
}