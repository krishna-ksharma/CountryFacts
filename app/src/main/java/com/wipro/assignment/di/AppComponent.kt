package com.wipro.assignment.di

import com.wipro.assignment.FactsApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by krishnas on 2/21/2019.
 */
@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class, ViewModelModule::class, ResourceModule::class, BuildersModule::class])
public interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: FactsApplication): Builder

        fun build(): AppComponent
    }

    abstract fun inject(app: FactsApplication)
}