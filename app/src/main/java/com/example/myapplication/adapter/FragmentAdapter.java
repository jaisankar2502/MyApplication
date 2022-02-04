package com.example.myapplication.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myapplication.fragments.Certificate;
import com.example.myapplication.fragments.Chat;
import com.example.myapplication.fragments.Score;
import com.example.myapplication.fragments.profile;

public class FragmentAdapter extends FragmentStateAdapter {
    public FragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return  new profile();
            case 1:
                return  new Certificate();
            case 2:
                return  new Chat();
            case 3:
                return  new Score();

        }
        return new profile();
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
