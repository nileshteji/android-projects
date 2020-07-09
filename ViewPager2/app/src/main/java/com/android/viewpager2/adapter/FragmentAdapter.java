package com.android.viewpager2.adapter;

import android.app.Activity;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.android.viewpager2.BlankFragment;

import java.util.ArrayList;

public class FragmentAdapter extends FragmentStateAdapter {

ArrayList<String> list;


    public FragmentAdapter(FragmentActivity activity, ArrayList<String> list){
        super(activity);
        this.list=list;


    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return new BlankFragment();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
