package com.wipro.assignment.rest.api

import com.wipro.assignment.rest.model.Facts
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by krishnas on 2/22/2019.
 * This class provides the facts API
 */
interface FactsApi {
    @GET("/s/{country}/facts.json")
    fun getFacts(@Path("country") country: String): Call<Facts>
}