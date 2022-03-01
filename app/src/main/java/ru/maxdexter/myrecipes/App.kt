package ru.maxdexter.myrecipes

import android.app.Application
import ru.maxdexter.myrecipes.di.component.AppComponent
import ru.maxdexter.myrecipes.di.component.DaggerAppComponent

class App : Application() {

    override fun onCreate() {
        super.onCreate()
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }
}