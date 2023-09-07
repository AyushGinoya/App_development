package com.example.tablayoutdemo;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyViewPagerAdapter extends FragmentStateAdapter {

    public MyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // Create and return fragments based on their position in the ViewPager2
        if (position == 0) {
            return new HomeFragment(); // Display the HomeFragment for position 0
        } else if (position == 1) {
            return new MessageFragment(); // Display the MessageFragment for position 1
        } else if (position == 2) {
            return new SettingsFragment(); // Display the SettingsFragment for position 2
        } else {
            return new HomeFragment(); // Default to HomeFragment if position is out of bounds
        }
    }

    @Override
    public int getItemCount() {
        return 3; // Total number of fragments/tabs in the ViewPager2
    }
}
