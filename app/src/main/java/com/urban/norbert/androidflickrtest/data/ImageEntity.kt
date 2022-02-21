package com.urban.norbert.androidflickrtest.data

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "images")
data class ImageEntity(
    @PrimaryKey(autoGenerate = true) var imageDBId: Long?,
    @ColumnInfo(name = "imageId") var imageId: String?,
    @ColumnInfo(name = "title") var title: String?,
    @ColumnInfo(name = "url") var url: String?,
    @ColumnInfo(name = "image") var image: Bitmap?,
    @ColumnInfo(name = "description") var description: String?
)

