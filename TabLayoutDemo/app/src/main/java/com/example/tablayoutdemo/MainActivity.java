package com.example.tablayoutdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout; // TabLayout to display tabs
    ViewPager2 viewPager2; // ViewPager2 for swiping between fragments
    MyViewPagerAdapter myViewPagerAdapter; // Adapter for ViewPager2

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize references to TabLayout and ViewPager2
        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.view_pager);

        // Create an instance of the custom adapter for ViewPager2
        myViewPagerAdapter = new MyViewPagerAdapter(this);

        // Set the adapter for ViewPager2
        viewPager2.setAdapter(myViewPagerAdapter);

        // Add a listener to TabLayout to sync tab selection with ViewPager2
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // Not used in this example
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // Not used in this example
            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();
            }
        });
    }
}
