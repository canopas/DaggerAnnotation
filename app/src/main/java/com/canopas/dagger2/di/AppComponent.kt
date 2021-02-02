package com.canopas.dagger2.di

import android.app.Application
import com.canopas.dagger2.UserApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, ActivityBinderModule::class,AndroidSupportInjectionModule::class])
public abstract class AppComponent : AndroidInjector<UserApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(context: Application): Builder
        fun build(): AppComponent
    }

}