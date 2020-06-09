package com.osos.paginglibrary.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.osos.paginglibrary.databinding.ActivityMainBinding;
import com.osos.paginglibrary.model.Details;
import com.osos.paginglibrary.utils.DataSourceFactory;
import com.osos.paginglibrary.utils.PageAdapter;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mainBinding;
    final static String TAG = "MainActivity";
    PageAdapter adapter;
    Executor executor;
  LiveData< PagedList<Details>> pagedList;
    DataSourceFactory dataSourceFactory;
    PagedList.Config pagedListConfig;
    Executor executor1;

    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View v = mainBinding.getRoot();
        setContentView(v);

        adapter = new PageAdapter();

        dataSourceFactory = new DataSourceFactory();
      executor=Executors.newSingleThreadExecutor();
      executor1=Executors.newSingleThreadExecutor();



        pagedListConfig = (new PagedList.Config.Builder())
                .setPageSize(20)

                .setEnablePlaceholders(true)
                .build();


     pagedList=new LivePagedListBuilder(dataSourceFactory,pagedListConfig)
             .setFetchExecutor(executor)
             .build();

     pagedList.observe(this, new Observer<PagedList<Details>>() {
         @Override
         public void onChanged(PagedList<Details> details) {
             adapter.submitList(details);
         }
     });

        mainBinding.recycler.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mainBinding.recycler.setLayoutManager(linearLayoutManager);

        mainBinding.refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mainBinding.refreshLayout.setRefreshing(true);

                pagedList=new LivePagedListBuilder(dataSourceFactory,pagedListConfig)
                        .setFetchExecutor(executor)
                        .build();

                pagedList.observe(MainActivity.this, new Observer<PagedList<Details>>() {
                    @Override
                    public void onChanged(PagedList<Details> details) {
                        adapter.submitList(details);
                        mainBinding.refreshLayout.setRefreshing(false);
                    }
                });

            }
        });
    }


}
