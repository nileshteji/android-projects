package com.osos.squareboatapplication.core.news

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.osos.squareboatapplication.R
import com.osos.squareboatapplication.model.Article
import kotlinx.android.synthetic.main.activity_news.*


class NewsActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        init()
        val article=intent.getParcelableExtra<Article>("article")


        //setting UP NEWS
        Glide.with(this)
            .load(article!!.image)
            .placeholder(R.drawable.ic_launcher_background)
            .into(newsImage)

        titleNews.text = article.title
        source.text = article.source?.name
        content.text = article.content


        //click listeners
        full_story.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(article.url))
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.setPackage("com.android.chrome")
            try {
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                // Chrome browser presumably not installed so allow user to choose instead
                intent.setPackage(null)
                startActivity(intent)
            }

        }



    }


    fun init() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = "News"

    }
}