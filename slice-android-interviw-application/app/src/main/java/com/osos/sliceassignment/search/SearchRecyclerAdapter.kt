package com.osos.sliceassignment.search

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.osos.sliceassignment.R
import com.osos.sliceassignment.databinding.TweetsListLayoutBinding
import com.osos.sliceassignment.model.Tweets



class SearchRecyclerAdapter(tweetsList:List<Tweets>,var context:SearchActivity) : RecyclerView.Adapter<SearchRecyclerAdapter.SearchViewHolder>() {
    lateinit var tweetsBinding:TweetsListLayoutBinding
    var tweetsList:List<Tweets> = tweetsList


    class SearchViewHolder(var binding: TweetsListLayoutBinding) : RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        tweetsBinding = TweetsListLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchViewHolder(tweetsBinding)
    }

   
    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        var tweetCurrent:Tweets = tweetsList.get(position)

        Glide.with(context).load(tweetCurrent.image)
            .placeholder(R.drawable.placeholder_profile_photo)
            .into(tweetsBinding.profileImage)
        tweetsBinding.userName.text = tweetCurrent.name
        tweetsBinding.twitterHandleName.text = tweetCurrent.handle
        tweetsBinding.content.text = tweetCurrent.text
        tweetsBinding.likeCount.text = tweetCurrent.like.toString()
        tweetsBinding.retweetCount.text = tweetCurrent.retweet.toString()
    }

    override fun getItemCount(): Int {
        return tweetsList.size
    }
}