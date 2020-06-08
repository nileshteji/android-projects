package com.osos.paginglibrary.utils;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;

import com.osos.paginglibrary.model.Details;

public class DataSourceFactory extends DataSource.Factory {
   PageDataSource dataSourceFactory;

   @NonNull
   @Override
   public DataSource<Integer, Details> create() {
      dataSourceFactory = new PageDataSource();
      return dataSourceFactory;
   }


}
