package com.wipro.assignment.data

import com.wipro.assignment.FactsTestCase
import com.wipro.assignment.MockFacts
import com.wipro.assignment.rest.model.Facts
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
        val dataSource = Mockito.mock(FactsDataSource::class.java)
        factsRepository = Mockito.spy<FactsRepository>(FactsRepository(dataSource))
    }

    @Test
    fun testNoFacts() {
        factsRepository.factsResult.value = null
        Assert.assertNull(factsRepository.factsResult.value)
    }

    @Test
    fun testHasFacts() {
        factsRepository.factsResult.value = Facts()
        Assert.assertNotNull(factsRepository.factsResult.value)
    }

    @Test
    fun testFactsContents() {
        factsRepository.factsResult.value = MockFacts.mockFact()
        val fact = factsRepository.factsResult.value
        Assert.assertNotNull(fact)
        Assert.assertNotNull(fact!!.title)
        Assert.assertNotNull(fact.rows)
    }
}