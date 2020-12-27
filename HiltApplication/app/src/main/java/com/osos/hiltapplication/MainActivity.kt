package com.osos.hiltapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Inject
import javax.inject.Qualifier


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var checkingHilt: CheckingHilt

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println(checkingHilt.getImplementationOne())
        println(checkingHilt.getImplementationTwo())
    }
}


class CheckingHilt @Inject constructor(
        @ImplOne private val serviceImplementationOne: service,
        @ImplTwo private val serviceImplementationTwo: service,
) {

    fun getImplementationOne(): String {
        return serviceImplementationOne.provideThing()
    }

    fun getImplementationTwo(): String {
        return serviceImplementationTwo.provideThing()
    }

}


interface service { fun provideThing(): String }


class ServiceImplementationOne @Inject constructor() : service {
    override fun provideThing(): String {
        return "A Thing One"
    }
}

class ServiceImplementationTwo @Inject constructor() : service {
    override fun provideThing(): String {
        return " A Thing Two"
    }
}


@InstallIn(ApplicationComponent::class)
@Module
class MyModule {

    @ImplOne
    @Provides
    fun getServiceImplementationOne(): service {
        return ServiceImplementationOne()
    }

    @ImplTwo
    @Provides
    fun getServiceImplementationTwo(): service {
        return ServiceImplementationTwo()
    }


}


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ImplOne



@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ImplTwo

