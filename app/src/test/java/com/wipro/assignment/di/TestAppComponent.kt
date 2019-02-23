package com.wipro.assignment.di

import com.wipro.assignment.FactsApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by krishnas on 2/23/2019.
 */
@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, TestAppModule::class, ViewModelModule::class, TestResourceModule::class, TestBuildersModule::class])
public interface TestAppComponent : AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: FactsApplication): Builder

        fun build(): TestAppComponent
    }
}