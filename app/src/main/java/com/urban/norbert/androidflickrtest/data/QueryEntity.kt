package com.urban.norbert.androidflickrtest.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "queryString")
data class QueryEntity(
    @PrimaryKey(autoGenerate = true) var queryDBId: Long?,
    @ColumnInfo(name = "query") var query: String,
)