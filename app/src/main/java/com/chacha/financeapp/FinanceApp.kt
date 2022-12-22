package com.chacha.financeapp

import android.app.Application
import com.chacha.financeapp.core.crashlytics.CrashlyticsTree
import dagger.hilt.android.HiltAndroidApp
import org.jetbrains.annotations.NotNull
import timber.log.Timber

@HiltAndroidApp
class FinanceApp : Application(){
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
             Timber.plant(Timber.DebugTree())
        }
        initTimber()
    }

    private fun initTimber() = when {
        BuildConfig.DEBUG -> {
            Timber.plant(object : Timber.DebugTree() {
                override fun createStackElementTag(@NotNull element: StackTraceElement): String {
                    return super.createStackElementTag(element) + ":" + element.lineNumber
                }
            })
        }
        else -> {
            Timber.plant(CrashlyticsTree())
        }
    }
}