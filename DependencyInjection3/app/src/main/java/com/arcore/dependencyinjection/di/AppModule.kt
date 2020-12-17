package com.arcore.dependencyinjection.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides

@Module
class AppModule(var dummyApplication: Application){

    @Provides
    fun getPreferences():SharedPreferences=dummyApplication
            .getSharedPreferences("DependencyInjection", Context.MODE_PRIVATE)
}

