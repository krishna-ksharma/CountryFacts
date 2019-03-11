package com.wipro.assignment.data

import com.wipro.assignment.api.Api
import com.wipro.assignment.rest.model.Facts
import retrofit2.Callback

/**
 * Created by krishnas on 2/22/2019.
 */
open class FactsNetworkDataSource {
    fun getFacts(callback: Callback<Facts>, country: String) {
        Api.fetchFacts(callback, country)
    }
}