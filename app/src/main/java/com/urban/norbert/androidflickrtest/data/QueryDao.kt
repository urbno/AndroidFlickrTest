package com.urban.norbert.androidflickrtest.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface QueryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuery(query: QueryEntity)

    @Query("SELECT * FROM queryString LIMIT 1")
    fun getQuery(): Flow<QueryEntity>

    @Query("DELETE FROM queryString")
    suspend fun deleteQuery()

    @Query("SELECT COUNT(queryDBId) from queryString")
    suspend fun count(): Int
}