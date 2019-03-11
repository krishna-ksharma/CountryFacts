package com.wipro.assignment.di


import android.content.Context
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import com.wipro.assignment.data.FactsLocalDataSource
import com.wipro.assignment.data.FactsNetworkDataSource
import com.wipro.assignment.data.FactsRepository
import com.wipro.assignment.database.FactsDatabase
import com.wipro.assignment.database.dao.FactsDAO
import com.wipro.assignment.database.entitiy.Fact
import dagger.Module
import dagger.Provides
import org.mockito.Mockito
import org.mockito.Mockito.*
import javax.inject.Singleton

/**
 * Created by krishnas on 2/23/2019.
 */
@Module
class TestResourceModule {
    @Provides
    @Singleton
    fun provideFactsNetworkDataSource(): FactsNetworkDataSource {
        return mock(FactsNetworkDataSource::class.java)
    }

    @Provides
    @Singleton
    fun providesFactsRepository(factsNetworkDataSource: FactsNetworkDataSource, factsLocalDataSource: FactsLocalDataSource): FactsRepository {
        var mockRepository = FactsRepository(factsNetworkDataSource, factsLocalDataSource)
        val mockFacts = MutableLiveData<List<Fact>>()
        doNothing().`when`(mockFacts).observe(any<LifecycleOwner>(), any())
        `when`(mockRepository.factsResult()).thenReturn(mockFacts)
        return mockRepository
    }

    @Provides
    @Singleton
    fun provideFactsLocalDataSource(): FactsLocalDataSource {
        return Mockito.spy<FactsLocalDataSource>(FactsLocalDataSource(mock(FactsDAO::class.java)))
    }

    @Provides
    @Singleton
    fun provideFactsDatabase(context: Context): FactsDatabase {
        return Room.inMemoryDatabaseBuilder(context, FactsDatabase::class.java).allowMainThreadQueries().build()
    }
}