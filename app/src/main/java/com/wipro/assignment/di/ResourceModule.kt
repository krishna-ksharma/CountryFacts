package com.wipro.assignment.di

import android.content.Context
import androidx.room.Room
import com.wipro.assignment.data.FactsLocalDataSource
import com.wipro.assignment.data.FactsNetworkDataSource
import com.wipro.assignment.data.FactsRepository
import com.wipro.assignment.database.FactsDatabase
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
    fun provideFactsNetworkDataSource(): FactsNetworkDataSource {
        return FactsNetworkDataSource()
    }

    @Provides
    @Singleton
    fun providesFactsRepository(factsNetworkDataSource: FactsNetworkDataSource, factsLocalDataSource: FactsLocalDataSource): FactsRepository {
        return FactsRepository(factsNetworkDataSource, factsLocalDataSource)
    }

    @Provides
    @Singleton
    fun provideFactsLocalDataSource(factsDatabase: FactsDatabase): FactsLocalDataSource {
        return FactsLocalDataSource(factsDatabase.factsDao())
    }

    @Provides
    @Singleton
    fun provideFactsDatabase(context: Context): FactsDatabase {
        return Room.databaseBuilder(context, FactsDatabase::class.java, "facts.db").build()
    }
}