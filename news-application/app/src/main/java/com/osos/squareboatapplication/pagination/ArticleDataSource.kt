package com.osos.squareboatapplication.pagination

import androidx.paging.PageKeyedDataSource
import com.osos.squareboatapplication.api.ApiBuilder
import com.osos.squareboatapplication.api.Constants
import com.osos.squareboatapplication.model.Article
import kotlinx.coroutines.*

class ArticleDataSource(
    var country: String,

    ) : PageKeyedDataSource<Int, Article>() {


    var INITIAL_PAGE_KEY = 1


    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Article>
    ) {

        val exceptionHandler: CoroutineExceptionHandler =
            CoroutineExceptionHandler { coroutineContext, throwable ->
                callback.onResult(emptyList(), null, null)
            }
        CoroutineScope(Dispatchers.IO).launch(exceptionHandler) {

            var listArticle = async {

                ApiBuilder.getApiCaller()
                    .default(country, Constants.API_KEY, INITIAL_PAGE_KEY,)

            }.await().articles

            callback.onResult(listArticle, null, INITIAL_PAGE_KEY + 1)
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Article>) {

        val exceptionHandler: CoroutineExceptionHandler =
            CoroutineExceptionHandler { coroutineContext, throwable ->
                callback.onResult(emptyList(), null)
            }

        CoroutineScope(Dispatchers.IO).launch(exceptionHandler) {

            var listArticle = async {

                ApiBuilder.getApiCaller()
                    .default(country, Constants.API_KEY, params.key - 1)

            }.await().articles

            callback.onResult(listArticle, params.key - 1)
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Article>) {

        val exceptionHandler: CoroutineExceptionHandler =
            CoroutineExceptionHandler { coroutineContext, throwable ->
                callback.onResult(emptyList(), null)
            }

        CoroutineScope(Dispatchers.IO).launch(exceptionHandler) {

            var listArticle = async {

                ApiBuilder.getApiCaller()
                    .default(country, Constants.API_KEY, params.key + 1)
            }.await().articles

            callback.onResult(listArticle, params.key + 1)
        }
    }


}