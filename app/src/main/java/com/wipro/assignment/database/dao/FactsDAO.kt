package com.wipro.assignment.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.wipro.assignment.database.entitiy.Fact


@Dao
interface FactsDAO {
    @Query("SELECT * FROM FACTS")
    fun findAllFacts(): LiveData<List<Fact>>

    @Query("DELETE FROM FACTS")
    fun deleteAllFacts()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(fact: List<Fact>)
}