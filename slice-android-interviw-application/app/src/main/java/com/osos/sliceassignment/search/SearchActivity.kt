package com.osos.sliceassignment.search

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.osos.sliceassignment.R
import com.osos.sliceassignment.databinding.ActivitySearchBinding
import com.osos.sliceassignment.model.Tweets

class SearchActivity : AppCompatActivity() {

    lateinit var searchBinding: ActivitySearchBinding
    lateinit var searchViewModel: SearchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        searchBinding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(searchBinding.root)
        searchViewModel = ViewModelProvider(this).get(SearchViewModel::class.java)
        searchBinding.searchButton.setOnClickListener {

            if (searchBinding.filledTextField.editText?.text?.isNotEmpty()!!) {
                hideHints()
                loadAnimations()
                searchViewModel.apiCall(searchBinding.filledTextField.editText?.text.toString())
                searchViewModel
                        .getList()
                        .observe(this){
                            if(it==null){
                              Toast.makeText(this@SearchActivity,"No Search Fount Try Another Key",Toast.LENGTH_LONG).show();
                            }
                            else {
                                cancelAnimation()
                                setupRecyclerView(it)
                            }
                        }


            } else {
                searchBinding.filledTextField.error="Please Enter Text"
            }

        }


    }


    fun setupRecyclerView(tweetsList: List<Tweets>) {
        searchBinding.tweetRecycler.visibility=View.VISIBLE
        searchBinding.tweetRecycler.adapter=SearchRecyclerAdapter(tweetsList,this@SearchActivity)
        var recyclerLayoutManager:LinearLayoutManager = LinearLayoutManager(this@SearchActivity, LinearLayoutManager.VERTICAL, false)
        searchBinding.tweetRecycler.layoutManager=recyclerLayoutManager

    }
    fun hideHints() {
        searchBinding.hintImageView.visibility = View.GONE
        searchBinding.hintText.visibility = View.GONE
    }

    fun loadAnimations() {
        searchBinding.loadingAnimation.visibility = View.VISIBLE;
        searchBinding.loadingAnimation.playAnimation()
    }

    fun showHints() {
        searchBinding.tweetRecycler.visibility=View.GONE
        searchBinding.loadingAnimation.visibility = View.GONE
        searchBinding.hintImageView.visibility = View.VISIBLE
        searchBinding.hintText.visibility = View.VISIBLE
    }

    fun cancelAnimation() {
        searchBinding.loadingAnimation.cancelAnimation()
        searchBinding.loadingAnimation.visibility = View.GONE
    }


    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }
    

    override fun onStart() {
        super.onStart()
        showHints()
        searchBinding.filledTextField.editText?.text?.clear()

    }


}