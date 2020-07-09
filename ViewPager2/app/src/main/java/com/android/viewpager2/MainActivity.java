package com.android.viewpager2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.Toast;

import com.android.viewpager2.adapter.FragmentAdapter;
import com.android.viewpager2.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
ArrayList<String> stringArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        stringArrayList=new ArrayList<>();
        stringArrayList.add("Nilesh");
        stringArrayList.add("Teji");
        stringArrayList.add("Taheem");
        binding.viewPager2.setAdapter(new FragmentAdapter(this,stringArrayList));
TabLayoutMediator tabLayoutMediator=new TabLayoutMediator(binding.tab, binding.viewPager2, true, new TabLayoutMediator.TabConfigurationStrategy() {
    @Override
    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
        tab.setText("TAB" +String.valueOf(position));
    }
});
tabLayoutMediator.attach();
        binding.viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                Toast.makeText(MainActivity.this, String.valueOf(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }
}