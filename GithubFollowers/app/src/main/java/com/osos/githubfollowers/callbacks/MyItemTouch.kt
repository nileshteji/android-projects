package com.osos.githubfollowers.callbacks

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.osos.githubfollowers.MainActivity
import com.osos.githubfollowers.clickListeners.OnClickRecycler

class MyItemTouch(on:OnClickRecycler):ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT){

    var onClick=on;

    override fun getMovementFlags( recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder
    ): Int {
        return makeMovementFlags(0,ItemTouchHelper.RIGHT);
    }

    override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
      return true;
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        if(direction==ItemTouchHelper.RIGHT){
        //  mainActivity.Delete(viewHolder.adapterPosition)
            onClick.Delete(viewHolder.adapterPosition)
       }

    }
}