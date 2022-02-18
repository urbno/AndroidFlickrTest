package com.urban.norbert.androidflickrtest.model.detail

data class Location(
    val accuracy: String,
    val context: String,
    val country: Country,
    val county: County,
    val latitude: String,
    val locality: Locality,
    val longitude: String,
    val neighbourhood: Neighbourhood,
    val region: Region
)