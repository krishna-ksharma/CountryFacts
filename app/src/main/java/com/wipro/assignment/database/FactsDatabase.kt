package com.wipro.assignment.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.wipro.assignment.database.dao.FactsDAO
import com.wipro.assignment.database.entitiy.Fact

@Database(entities = [Fact::class], version = 1)
open abstract class FactsDatabase : RoomDatabase() {
    abstract fun factsDao(): FactsDAO
}

