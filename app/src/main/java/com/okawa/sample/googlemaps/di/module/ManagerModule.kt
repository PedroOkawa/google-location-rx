package com.okawa.sample.googlemaps.di.module

import com.okawa.sample.googlemaps.utils.PermissionsManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ManagerModule {

    @Singleton
    @Provides
    fun providesPermissionsManager(): PermissionsManager {
        return PermissionsManager()
    }

}