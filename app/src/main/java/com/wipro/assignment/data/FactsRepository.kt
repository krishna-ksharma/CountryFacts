package com.wipro.assignment.data

import androidx.annotation.NonNull
import androidx.lifecycle.MutableLiveData
import com.wipro.assignment.rest.model.Facts
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.stream.Collectors

/**
 * Created by krishnas on 2/22/2019.
 */
open class FactsRepository(private val factsNetworkDataSource: FactsDataSource) {
    val factsResult = MutableLiveData<Facts>()

    fun fetchFacts(country: String) {
        val callback = object : Callback<Facts> {
            override fun onResponse(@NonNull call: Call<Facts>, @NonNull response: Response<Facts>) {
                val result = response.body()
                if (!result?.rows.isNullOrEmpty()) {
                    result?.rows = filterValidRows(result?.rows!!)
                }
                factsResult.postValue(result)
            }

            fun filterValidRows(rows: List<Facts.Row>): List<Facts.Row> {
                return rows.stream()
                        .filter({ row -> excludeEmptyRow(row) })
                        .collect(Collectors.toList())
            }

            fun excludeEmptyRow(row: Facts.Row): Boolean {
                return !row.title.isNullOrEmpty() && !row.description.isNullOrEmpty() && !row.imageHref.isNullOrEmpty()
            }

            override fun onFailure(call: Call<Facts>?, t: Throwable?) {
                factsResult.postValue(null)
            }
        }
        factsNetworkDataSource.getFacts(callback, country)
    }
}