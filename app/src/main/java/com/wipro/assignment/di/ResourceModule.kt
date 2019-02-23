package com.wipro.assignment.di

import com.wipro.assignment.data.FactsDataSource
import com.wipro.assignment.data.FactsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by krishnas on 2/22/2019.
 */
@Module
class ResourceModule {
    @Provides
    @Singleton
    fun provideFactsNetworkDataSource(): FactsDataSource {
        return FactsDataSource()
    }

    @Provides
    @Singleton
    fun providesFactsRepository(factsDataSource: FactsDataSource): FactsRepository {
        return FactsRepository(factsDataSource)
    }
}