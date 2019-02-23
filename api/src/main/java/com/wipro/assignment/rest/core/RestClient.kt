package com.wipro.assignment.rest.core

import com.wipro.assignment.rest.api.FactsApi
import com.wipro.assignment.rest.di.DaggerRestComponent
import com.wipro.assignment.rest.di.RestModule
import javax.inject.Inject


/**
 * Created by krishnas on 2/22/2019.
 * This class provides the access of the Api defined under api package
 */
class RestClient {
    companion object {
        @JvmStatic
        var instance = RestClient()
    }

    @Inject
    lateinit var factsApi: FactsApi

    @Inject constructor() {
        setupRestClient()
    }

    /**
     * Sets up the rest client
     */
    private fun setupRestClient() {
        DaggerRestComponent.builder()
                .restModule(RestModule("https://dl.dropboxusercontent.com"))
                .build()
                .inject(this)
    }
}