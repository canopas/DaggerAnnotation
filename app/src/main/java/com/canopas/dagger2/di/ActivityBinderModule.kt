package com.canopas.dagger2.di

import com.canopas.dagger2.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBinderModule {

    @ContributesAndroidInjector
    abstract fun provideMainActivity(): MainActivity
}