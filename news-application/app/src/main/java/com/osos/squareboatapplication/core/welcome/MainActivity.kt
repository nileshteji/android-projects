package com.osos.squareboatapplication.core.welcome

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.osos.squareboatapplication.R
import com.osos.squareboatapplication.adapters.NewsAdapter
import com.osos.squareboatapplication.adapters.PagedAdapter
import com.osos.squareboatapplication.bottomsheets.LocationModalSheet
import com.osos.squareboatapplication.bottomsheets.SourceModalSheet
import com.osos.squareboatapplication.clicklisteners.RecyclerViewClick
import com.osos.squareboatapplication.core.news.NewsActivity
import com.osos.squareboatapplication.model.Article
import com.osos.squareboatapplication.model.SORT
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RecyclerViewClick {


    var TAG: String = "LOGS"
    lateinit var viewModel: NewsViewModel
    lateinit var countryText: String
    lateinit var adapter: NewsAdapter
    var queryGlobal: String? = null
    lateinit var pagedAdapter: PagedAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        init()


        //MainList
        viewModel.getHeadLines().observe(this) {

            if (it == null) {
                Toast.makeText(this, "Sorry Something Went Wrong", Toast.LENGTH_LONG).show()
            } else if (it.isEmpty()) {
                Toast.makeText(this, "Sorry No Results Available", Toast.LENGTH_LONG).show()
            } else {
                setRecyclerView(it)
            }

        }


        //searchView Listeners
        search_bar.setOnQueryTextListener(object : android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                queryGlobal = query
                viewModel.searchQuery(query)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                queryGlobal = newText
                Log.d(TAG, "onQueryTextChange: $queryGlobal")
                return false
            }

        })


        //spinner listeners
        spinner_filter.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
                when (position) {
                    1 -> filterCategory(SORT.POPULARITY)
                    2 -> filterCategory(SORT.RELEVANCY)
                }


            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }


        // view click listeners
        placeholder_filter.setOnClickListener {
            spinner_filter.performClick()
        }
        search_bar.setOnClickListener {
            search_bar.onActionViewExpanded()
        }


        // Modal Bottom Sheets
        country.setOnClickListener {
            var locationModel = LocationModalSheet(this)
            locationModel.show(supportFragmentManager, "Model")
        }
        floatingButton.setOnClickListener {
            var sourceModal = SourceModalSheet(this)
            sourceModal.show(supportFragmentManager, "ModelOne")
        }


    }

    // -------x-------


    //spinner method and intial headlines default location is India
    fun init() {
        ArrayAdapter.createFromResource(
            this,
            R.array.filter_array,
            R.layout.support_simple_spinner_dropdown_item
        ).run {
                this.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
                spinner_filter.adapter = this
            }


        showHeadlines("in")


        AlertDialog.Builder(this)
            .setTitle("NOTE")
            .setMessage(" Application For SquareBoat . Made By Nilesh ")
            .setPositiveButton("ok") { dialog, it ->
                dialog.dismiss()
            }.show()

    }


    // Top Headlines
    fun showHeadlines(a: String) {
        setLocation(a)
        handlingSearch()
        viewModel.fetchTopHeadLines(a)
    }

    fun filterSources(a: List<String>) {
        handlingSearch()
        viewModel.sortSources(a)
    }


    fun filterCategory(sort: SORT) {
        if (!queryGlobal.isNullOrEmpty()) {
            when (sort) {
                SORT.POPULARITY -> {
                    placeholder_filter.text = resources.getStringArray(R.array.filter_array).get(1)
                    viewModel.categorizeSearch(queryGlobal, "popularity")
                }
                SORT.RELEVANCY -> {
                    placeholder_filter.text = resources.getStringArray(R.array.filter_array).get(2)
                    viewModel.categorizeSearch(queryGlobal, "relevancy")
                }

            }
        } else {
            Toast.makeText(this, "Search Something", Toast.LENGTH_LONG).show()
        }
    }



    fun setRecyclerView(list: List<Article>) {
        val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        adapter = NewsAdapter(list, this@MainActivity)
        recyclerView2.adapter = adapter
        recyclerView2.layoutManager = linearLayoutManager
    }



    // country text change
    fun setLocation(a: String) {
        countryText = a

        when (a) {

            "br" -> country.text = getString(R.string.brazil)
            "us" -> country.text = getString(R.string.usa)
            "in" -> country.text = getString(R.string.india)
            "ar" -> country.text = getString(R.string.argetina)
            "cn" -> country.text = getString(R.string.china)
            "au" -> country.text = getString(R.string.australia)
            "pk" -> country.text = getString(R.string.Pakistan)

        }
    }


    fun handlingSearch() {
        placeholder_filter.text = resources.getStringArray(R.array.filter_array).get(0)
        search_bar.setQuery("", false)
        search_bar.clearFocus()
    }


    override fun onBackPressed() {
        if (!search_bar.isIconified) {
            search_bar.isIconified = true
        } else {
            super.onBackPressed()
        }
    }

    override fun click(article: Article) {
        val intent = Intent(this, NewsActivity::class.java)
        intent.putExtra("article", article)
        startActivity(intent)
    }


}


