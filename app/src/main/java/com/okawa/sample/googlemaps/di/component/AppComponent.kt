package com.okawa.sample.googlemaps.di.component

import com.okawa.sample.googlemaps.common.App
import com.okawa.sample.googlemaps.data.di.DataModule
import com.okawa.sample.googlemaps.data.di.SchedulerModule
import com.okawa.sample.googlemaps.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ActivityBuilderModule::class,
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        AppModule::class,
        DataModule::class,
        FragmentBuilderModule::class,
        ManagerModule::class,
        SchedulerModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun application(app: App): Builder
    }
}