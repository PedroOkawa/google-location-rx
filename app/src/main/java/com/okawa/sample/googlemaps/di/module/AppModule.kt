package com.okawa.sample.googlemaps.di.module

import android.content.Context
import com.okawa.sample.googlemaps.common.App
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun providesAppContext(app: App): Context {
        return app
    }

}