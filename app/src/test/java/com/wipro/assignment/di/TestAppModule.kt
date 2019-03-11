package com.wipro.assignment.di

import android.content.Context
import com.wipro.assignment.FactsApplication
import com.wipro.assignment.TestFactsApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by krishnas on 2/23/2019.
 */
@Module
class TestAppModule {
    @Provides
    @Singleton
    internal fun provideContext(application: TestFactsApplication): Context {
        return application.applicationContext
    }
}