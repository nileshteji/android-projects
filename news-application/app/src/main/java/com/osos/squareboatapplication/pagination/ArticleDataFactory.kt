package com.osos.squareboatapplication.pagination

import androidx.paging.DataSource
import com.osos.squareboatapplication.model.Article

 class ArticleDataFactory(var country:String): DataSource.Factory<Int,Article>() {

    override fun create(): DataSource<Int, Article> = ArticleDataSource(country)

}