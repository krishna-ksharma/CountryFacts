package com.wipro.assignment.data

import androidx.lifecycle.LiveData
import com.wipro.assignment.database.dao.FactsDAO
import com.wipro.assignment.database.entitiy.Fact

open class FactsLocalDataSource(private val factsDAO: FactsDAO) {
    fun loadFacts(): LiveData<List<Fact>> {
        return factsDAO.findAllFacts()
    }

    fun deleteFacts() {
        factsDAO.deleteAllFacts()
    }

    fun insertFacts(facts: List<Fact>) {
        factsDAO.insertAll(facts)
    }
}