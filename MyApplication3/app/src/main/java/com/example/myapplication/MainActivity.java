package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
FloatingActionButton fb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

fb=(FloatingActionButton)findViewById(R.id.fab);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                if(i==0){
                    fb.setImageResource(R.drawable.ic_mode_edit_black_24dp);
                }
                else if(i==1){
                    fb.setImageResource(R.drawable.ic_navigate_before_black_24dp);
                }

                else if(i==2){
                    fb.setImageResource(R.drawable.ic_navigate_next_black_24dp);
                }
            }

            @Override
            public void onPageSelected(int i) {
//                if(i==0){
//                    fb.setImageResource(R.drawable.ic_mode_edit_black_24dp);
//                }
//                else if(i==1){
//                    fb.setImageResource(R.drawable.ic_navigate_before_black_24dp);
//                }
//
//                else if(i==2){
//                    fb.setImageResource(R.drawable.ic_navigate_next_black_24dp);
//                }

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        TabLayout tabs = findViewById(R.id.tabs);


        tabs.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));


        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabs));


    }

    public static class MyFragment extends Fragment {

        public static MyFragment newInstance(int sectionNumber) {
            MyFragment mf = new MyFragment();
            Bundle b = new Bundle();
            b.putInt("Section_Number", sectionNumber);
            mf.setArguments(b);


            return mf;
        }

        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.fragment_main, container, false);
            TextView tv = (TextView) v.findViewById(R.id.section_label);
            tv.setText("Hello from Section " + getArguments().getInt("Section_Number"));

            return v;
        }
    }





    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
      public Fragment getItem(int i) {

                switch (i) {
                    case 0:
                        //fb.setImageResource(array[0]);
                        return new BlankFragment();


                    case 1:
                      //  fb.setImageResource(array[1]);
                        return new BlankFragment2();

                    case 2:
                        //fb.setImageResource(array[2]);
                        return new BlankFragment3();

                    default:
                        //fb.setImageResource(array[0]);
                        return new BlankFragment3();

                }
            }

        @Override
        public int getCount() {
            return 3;
        }

        /*@Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Tab 1";
                case 1:
                    return "Tab 2";
                case 2:
                    return "Tab 3";
                default:
                    return "Tabs";
            }
        }*/
    }
}