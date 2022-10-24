package me.itanik.listofusers

import android.app.Application
import android.content.Context
import me.itanik.listofusers.di.AppComponent
import me.itanik.listofusers.di.DaggerAppComponent

class App : Application() {

    private var _appComponent: AppComponent? = null
    internal val appComponent: AppComponent
        get() = checkNotNull(_appComponent) { "App component doesn't initialized" }

    override fun onCreate() {
        super.onCreate()
        _appComponent = DaggerAppComponent.factory().create(applicationContext)
    }
}

val Context.appComponent: AppComponent
    get() = when (this) {
        is App -> appComponent
        else -> applicationContext.appComponent
    }