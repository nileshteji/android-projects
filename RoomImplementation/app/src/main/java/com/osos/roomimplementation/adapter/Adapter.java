package com.osos.roomimplementation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.osos.roomimplementation.R;
import com.osos.roomimplementation.database.Person;
import com.osos.roomimplementation.databinding.RecyclerListBinding;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.Holder> {
    Context context;
    List<Person> personList;

    public Adapter(Context applicationContext, List<Person> personList) {
        this.context = applicationContext;
        this.personList = personList;
    }


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerListBinding recyclerListBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.recycler_list, parent, false);
        return new Holder(recyclerListBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.recyclerListBinding.title.setText(personList.get(position).getTopic());
        holder.recyclerListBinding.title2.setText(personList.get(position).getNote());

    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        RecyclerListBinding recyclerListBinding;

        public Holder(@NonNull RecyclerListBinding recyclerListBinding) {
            super(recyclerListBinding.getRoot());
            this.recyclerListBinding = recyclerListBinding;

        }


    }
}
