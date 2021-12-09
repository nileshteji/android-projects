package com.osos.blushed;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

import com.osos.blushed.Model.Message;

import java.util.ArrayList;

public class diffUtils extends DiffUtil.Callback {
    ArrayList<Message> oldList;
    ArrayList<Message> newList;

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }

    diffUtils(ArrayList<Message> oldList , ArrayList<Message> newList)
    {
        this.oldList=oldList;
        this.newList=newList;
    }


    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).equals(newList.get(newItemPosition));
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).equals(newList.get(newItemPosition));
    }
}
