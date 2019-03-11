package com.wipro.assignment.data

import android.os.AsyncTask
import androidx.annotation.NonNull
import androidx.lifecycle.LiveData
import com.wipro.assignment.data.FactEntityMapper.Companion.toEntities
import com.wipro.assignment.database.entitiy.Fact
import com.wipro.assignment.rest.model.Facts
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.stream.Collectors

/**
 * Created by krishnas on 2/22/2019.
 */
open class FactsRepository(private val factsNetworkNetworkDataSource: FactsNetworkDataSource, private val factsLocalDataSource: FactsLocalDataSource) {
    fun factsResult(): LiveData<List<Fact>> {
        return factsLocalDataSource.loadFacts()
    }

    fun loadFacts(country: String) {
        val callback = object : Callback<Facts> {
            override fun onResponse(@NonNull call: Call<Facts>, @NonNull response: Response<Facts>) {
                val result = response.body()!!
                if (!result?.rows.isNullOrEmpty()) {
                    result?.rows = filterValidRows(result?.rows!!)
                }
                SaveFactsTask(factsLocalDataSource, result).execute()
            }

            override fun onFailure(call: Call<Facts>?, t: Throwable?) {}
        }
        factsNetworkNetworkDataSource.getFacts(callback, country)
    }

    private fun filterValidRows(rows: List<Facts.Row>): List<Facts.Row> {
        return rows.stream()
                .filter { row -> excludeEmptyRow(row) }
                .collect(Collectors.toList())
    }

    private fun excludeEmptyRow(row: Facts.Row): Boolean {
        return !row.title.isNullOrEmpty() || !row.description.isNullOrEmpty() || !row.imageHref.isNullOrEmpty()
    }

    private class SaveFactsTask constructor(val localDataSource: FactsLocalDataSource, val fact: Facts) : AsyncTask<Void, Void, Void>() {
        override fun doInBackground(vararg params: Void?): Void? {
            localDataSource.deleteFacts()
            localDataSource.insertFacts(toEntities(fact))
            return null
        }
    }
}