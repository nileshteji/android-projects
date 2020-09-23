package com.osos.githubfollowers

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.osos.githubfollowers.databinding.RecyclerBinding
import com.osos.githubfollowers.model.Followers
import com.squareup.picasso.Picasso


public class Adapter(context: Context, followers: ArrayList<Followers>) :
    RecyclerView.Adapter<Adapter.Holder>() {

    var context = context;
    var arrayList: ArrayList<Followers> = followers;

    class Holder(recyclerBinding: RecyclerBinding) : RecyclerView.ViewHolder(recyclerBinding.root) {

        var binding = recyclerBinding;

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(RecyclerBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        Picasso.get().load(arrayList.get(position).avatar_url).into(holder.binding.imageView2)
        holder.binding.textView.text = arrayList.get(position).login;
    }

    override fun getItemCount(): Int = arrayList.size
}
