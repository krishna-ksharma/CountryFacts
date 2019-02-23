package com.wipro.assignment

import com.wipro.assignment.data.FactsDataSource
import com.wipro.assignment.data.FactsRepository
import com.wipro.assignment.rest.model.Facts
import com.wipro.assignment.ui.viewmodel.FactsViewModel
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.spy

/**
 * Created by krishnas on 2/23/2019.
 */
class FactsViewModelTest : FactsTestCase() {

    private lateinit var factsViewModel: FactsViewModel
    private lateinit var factsRepository: FactsRepository

    @Before
    fun setup() {
        val dataSource = mock(FactsDataSource::class.java)
        factsRepository = spy<FactsRepository>(FactsRepository(dataSource))
        factsViewModel = FactsViewModel(factsRepository)
    }

    @Test
    fun testEmptyFacts() {
        factsRepository.factsResult.value = null
        assertTrue(factsViewModel.factsResult().value == null)
    }

    @Test
    fun testHasFacts() {
        factsRepository.factsResult.value = Facts()
        assertTrue(factsViewModel.factsResult().value != null)
    }
}