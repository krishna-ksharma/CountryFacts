package com.wipro.assignment.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.wipro.assignment.data.FactsRepository
import com.wipro.assignment.database.entitiy.Fact
import javax.inject.Inject

/**
 * Created by krishnas on 2/22/2019.
 */
open class FactsViewModel @Inject constructor(private val repository: FactsRepository) : ViewModel() {
    fun fetchFacts(country: String) {
        repository.loadFacts(country)
    }

    fun factsResult(): LiveData<List<Fact>> {
        return repository.factsResult()
    }
}