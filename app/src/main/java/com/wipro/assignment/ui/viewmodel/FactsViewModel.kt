package com.wipro.assignment.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wipro.assignment.data.FactsRepository
import com.wipro.assignment.rest.model.Facts
import javax.inject.Inject

/**
 * Created by krishnas on 2/22/2019.
 */
class FactsViewModel @Inject constructor(private val repository: FactsRepository) : ViewModel() {
    fun fetchFacts(country: String) {
        repository.fetchFacts(country)
    }

    fun factsResult(): MutableLiveData<Facts> {
        return repository.factsResult
    }
}