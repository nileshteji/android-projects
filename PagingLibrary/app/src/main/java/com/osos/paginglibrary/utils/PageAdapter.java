package com.osos.paginglibrary.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.osos.paginglibrary.databinding.RecyclerLayoutBinding;
import com.osos.paginglibrary.model.Details;

import java.util.List;

public class PageAdapter extends PagedListAdapter<Details, PageAdapter.PageViewHolder> {

    private static DiffUtil.ItemCallback<Details> detailsItemCallback = new DiffUtil.ItemCallback<Details>() {
        @Override
        public boolean areItemsTheSame(@NonNull Details oldItem, @NonNull Details newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull Details oldItem, @NonNull Details newItem) {
            return oldItem.equals(newItem);
        }
    };
    List<Details> list;
    Context c;


    public PageAdapter() {
        super(detailsItemCallback);
    }

    @NonNull
    @Override
    public PageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerLayoutBinding recyclerLayoutBinding = RecyclerLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PageViewHolder(recyclerLayoutBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PageViewHolder holder, int position) {

        Details details=getItem(position);

        if(details!=null){
            holder.recyclerLayoutBinding.text.setText(details.getTitle());
        }
        else{
            holder.recyclerLayoutBinding.text.setText("Sorry");

        }

    }



    class PageViewHolder extends RecyclerView.ViewHolder {
        RecyclerLayoutBinding recyclerLayoutBinding;

        public PageViewHolder(@NonNull RecyclerLayoutBinding recyclerLayoutBinding) {
            super(recyclerLayoutBinding.getRoot());
            this.recyclerLayoutBinding = recyclerLayoutBinding;

        }
    }
}
