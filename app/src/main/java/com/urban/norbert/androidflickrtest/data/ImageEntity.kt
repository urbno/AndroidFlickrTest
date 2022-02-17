package com.urban.norbert.androidflickrtest.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "images")
data class ImageEntity(
    @PrimaryKey(autoGenerate = true) var imageDBId: Long?,
    @ColumnInfo(name = "imageId") var imageId: String?
)

