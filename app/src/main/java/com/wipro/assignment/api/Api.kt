package com.wipro.assignment.api

import com.wipro.assignment.rest.core.RestClient
import com.wipro.assignment.rest.model.Facts
import retrofit2.Callback

/**
 * Created by krishnas on 2/22/2019.
 */
class Api {
    companion object {
        @JvmStatic
        fun fetchFacts(callback: Callback<Facts>, country: String) {
            val call = RestClient.instance.factsApi.getFacts(country)
            call.enqueue(callback)
        }
    }
}