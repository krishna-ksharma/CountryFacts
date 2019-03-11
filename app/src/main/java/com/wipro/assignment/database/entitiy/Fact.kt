package com.wipro.assignment.database.entitiy

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "facts")
data class Fact @JvmOverloads constructor(
        @ColumnInfo(name = "country") var country: String? = null,
        @ColumnInfo(name = "title") var title: String? = null,
        @ColumnInfo(name = "description") var description: String? = null,
        @ColumnInfo(name = "imageHref") var imageHref: String? = null,
        @PrimaryKey @ColumnInfo(name = "id") var id: String = UUID.randomUUID().toString()
)