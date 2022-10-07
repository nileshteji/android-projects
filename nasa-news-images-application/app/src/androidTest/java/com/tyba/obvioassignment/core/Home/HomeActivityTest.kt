package com.tyba.obvioassignment.core.Home

import androidx.lifecycle.ViewModelProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.tyba.obvioassignment.ObvioApplication
import com.tyba.obvioassignment.R
import com.tyba.obvioassignment.adapters.ImageAdapter
import com.tyba.obvioassignment.data.JsonData
import com.tyba.obvioassignment.datasource.JsonDataSource
import kotlinx.android.synthetic.main.activity_main.*
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class HomeActivityTest{

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)


    var LIST_ITEM_IN_TEST = 3
    var context = ObvioApplication.getIntance()
    var jsonDataSource = JsonDataSource(context)
    var jsonData = jsonDataSource.convertJsonToGson()

    //check if recycler View is Displayes
    @Test
    fun is_recycler_view_displayed(){
        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()))
    }

    @Test
    fun click_item_on_recycler_view_check_detail_activity(){
        onView(withId(R.id.recyclerView)).perform(actionOnItemAtPosition<ImageAdapter.Holder>(LIST_ITEM_IN_TEST,click()))

        onView(withId(R.id.detailTitle)).check(matches(withText(jsonData[LIST_ITEM_IN_TEST].title)))
    
        onView(withId(R.id.detail)).check(matches(withText(jsonData[LIST_ITEM_IN_TEST].explanation)))
    }

    @Test
    fun back_press_detail_activity(){
        onView(withId(R.id.recyclerView)).perform(actionOnItemAtPosition<ImageAdapter.Holder>(LIST_ITEM_IN_TEST,click()))

        onView(withId(R.id.detailTitle)).check(matches(withText(jsonData[LIST_ITEM_IN_TEST].title)))

        pressBack()

        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()))
    }


}