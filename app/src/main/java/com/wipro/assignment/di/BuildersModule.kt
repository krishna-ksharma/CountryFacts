package com.wipro.assignment.di

import com.wipro.assignment.ui.FactsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import layout.FactsFragment

/**
 * Created by krishnas on 2/22/2019.
 */
@Module
abstract class BuildersModule {
    @ContributesAndroidInjector
    abstract fun bindFactsActivity(): FactsActivity

    @ContributesAndroidInjector(modules = [ResourceModule::class, ViewModelModule::class])
    abstract fun bindFactsFragment(): FactsFragment
}