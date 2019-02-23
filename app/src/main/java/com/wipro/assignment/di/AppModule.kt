package com.wipro.assignment.di

import android.content.Context
import com.wipro.assignment.FactsApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by krishnas on 2/21/2019.
 */
@Module
class AppModule {
    @Provides
    @Singleton
    internal fun provideContext(application: FactsApplication): Context {
        return application.applicationContext
    }
}