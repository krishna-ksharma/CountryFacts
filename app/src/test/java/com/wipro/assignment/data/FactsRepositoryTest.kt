package com.wipro.assignment.data

import androidx.lifecycle.MutableLiveData
import com.wipro.assignment.FactsTestCase
import com.wipro.assignment.LiveDataExtension
import com.wipro.assignment.MockFacts
import com.wipro.assignment.database.dao.FactsDAO
import com.wipro.assignment.database.entitiy.Fact
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

/**
 * Created by krishnas on 2/24/2019.
 */
class FactsRepositoryTest : FactsTestCase() {
    private lateinit var factsRepository: FactsRepository

    @Before
    fun setup() {
        val networkDataSource = Mockito.mock(FactsNetworkDataSource::class.java)
        factsRepository = Mockito.spy<FactsRepository>(FactsRepository(networkDataSource, Mockito.spy<FactsLocalDataSource>(FactsLocalDataSource(Mockito.mock(FactsDAO::class.java)))))
    }

    @Test
    fun testNoFacts() {
        val mockFacts = MutableLiveData<List<Fact>>()
        Mockito.`when`(factsRepository.factsResult()).thenReturn(mockFacts)
        Assert.assertNull(LiveDataExtension.getValue(factsRepository.factsResult()))
    }

    @Test
    fun testHasFacts() {
        val mockFacts = MutableLiveData<List<Fact>>()
        mockFacts.value = ArrayList<Fact>()
        Mockito.`when`(factsRepository.factsResult()).thenReturn(mockFacts)
        Assert.assertNotNull(LiveDataExtension.getValue(factsRepository.factsResult()))
    }

    @Test
    fun testFactsContents() {
        val mockFacts = MutableLiveData<List<Fact>>()
        mockFacts.value = createFacts()
        Mockito.`when`(factsRepository.factsResult()).thenReturn(mockFacts)
        val facts = LiveDataExtension.getValue(factsRepository.factsResult())
        Assert.assertEquals(facts.size, 1)
        Assert.assertNotNull(facts[0].title)
    }

    private fun createFacts(): ArrayList<Fact> {
        val facts = ArrayList<Fact>()
        facts.add(MockFacts.mockEntityFact())
        return facts
    }
}