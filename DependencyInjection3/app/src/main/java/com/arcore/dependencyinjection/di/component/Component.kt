package com.arcore.dependencyinjection.di.component
import com.arcore.dependencyinjection.di.AppModule
import com.arcore.dependencyinjection.di.MainActivity
import dagger.Component




@Component(modules = [AppModule::class])
interface Component {
    fun inject(mainActivity: MainActivity);
}