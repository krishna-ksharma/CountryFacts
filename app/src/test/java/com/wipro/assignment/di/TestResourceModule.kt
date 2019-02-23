package com.wipro.assignment.di


import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import com.wipro.assignment.data.FactsDataSource
import com.wipro.assignment.data.FactsRepository
import com.wipro.assignment.rest.model.Facts
import dagger.Module
import dagger.Provides
import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito.*
import javax.inject.Singleton

/**
 * Created by krishnas on 2/23/2019.
 */
@Module
class TestResourceModule {
    @Provides
    @Singleton
    fun provideFactsNetworkDataSource(): FactsDataSource {
        return mock(FactsDataSource::class.java)
    }

    @Provides
    @Singleton
    fun providesFactsRepository(factsDataSource: FactsDataSource): FactsRepository {
        var mockRepository = mock(FactsRepository::class.java)

        val mockFacts = MutableLiveData<Facts>()

        doNothing().`when`(mockFacts).observe(any<LifecycleOwner>(), any())

        `when`(mockRepository.factsResult).thenReturn(mockFacts)

        return mockRepository
    }
}