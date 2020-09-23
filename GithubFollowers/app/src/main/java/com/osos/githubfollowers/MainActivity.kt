package com.osos.githubfollowers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.osos.githubfollowers.api.RetrofitApi
import com.osos.githubfollowers.api.profileRequest
import com.osos.githubfollowers.model.Followers
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    lateinit var api:Retrofit
    lateinit var adapter: Adapter;
    lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        api=RetrofitApi.getInstance()


        lifecycleScope.launch(Dispatchers.IO){

            async {
                var response= api.create(profileRequest::class.java).getName(Constants.user)


                withContext(Dispatchers.Main){
                    Picasso.get().load(response.avatar_url).into(imageView)
                    name.text=response.name
                    textView2.text=response.bio;
                    textView5.text=response.company


                }
            }

            async {
                var response:ArrayList<Followers> = api.create(profileRequest::class.java).getFollowers(Constants.user)
                adapter=Adapter(this@MainActivity,response)
                linearLayoutManager= LinearLayoutManager(this@MainActivity);
                linearLayoutManager.orientation=LinearLayoutManager.VERTICAL
                withContext(Dispatchers.Main){
                    rec.adapter=adapter
                    rec.layoutManager=linearLayoutManager
                }


            }
        }






    }
}