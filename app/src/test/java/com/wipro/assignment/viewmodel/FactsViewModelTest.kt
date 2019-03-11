package com.wipro.assignment.viewmodel

import androidx.lifecycle.MutableLiveData
import com.wipro.assignment.FactsTestCase
import com.wipro.assignment.LiveDataExtension
import com.wipro.assignment.MockFacts
import com.wipro.assignment.data.FactsLocalDataSource
import com.wipro.assignment.data.FactsNetworkDataSource
import com.wipro.assignment.data.FactsRepository
import com.wipro.assignment.database.dao.FactsDAO
import com.wipro.assignment.database.entitiy.Fact
import com.wipro.assignment.ui.viewmodel.FactsViewModel
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock

/**
 * Created by krishnas on 2/23/2019.
 */
class FactsViewModelTest : FactsTestCase() {

    private lateinit var factsViewModel: FactsViewModel

    @Before
    fun setup() {
        val dataSource = mock(FactsNetworkDataSource::class.java)
        val localDataSource = Mockito.spy<FactsLocalDataSource>(FactsLocalDataSource(Mockito.mock(FactsDAO::class.java)))
        val factsRepository = Mockito.spy<FactsRepository>(FactsRepository(dataSource, localDataSource))
        factsViewModel = FactsViewModel(factsRepository)
    }

    @Test
    fun testEmptyFacts() {
        val mockFacts = MutableLiveData<List<Fact>>()
        Mockito.`when`(factsViewModel.factsResult()).thenReturn(mockFacts)
        Assert.assertNull(LiveDataExtension.getValue(factsViewModel.factsResult()))
    }

    @Test
    fun testHasFacts() {
        val mockFacts = MutableLiveData<List<Fact>>()
        mockFacts.value = ArrayList<Fact>()
        Mockito.`when`(factsViewModel.factsResult()).thenReturn(mockFacts)
        Assert.assertNotNull(LiveDataExtension.getValue(factsViewModel.factsResult()))
    }

    @Test
    fun testFactsContents() {
        val mockFacts = MutableLiveData<List<Fact>>()
        mockFacts.value = createFacts()
        Mockito.`when`(factsViewModel.factsResult()).thenReturn(mockFacts)
        val facts = LiveDataExtension.getValue(factsViewModel.factsResult())
        Assert.assertEquals(facts.size, 1)
        Assert.assertNotNull(facts[0].title)
    }

    private fun createFacts(): ArrayList<Fact> {
        val facts = ArrayList<Fact>()
        facts.add(MockFacts.mockEntityFact())
        return facts
    }
}