package com.urban.norbert.androidflickrtest.network

object NetworkConfig {
    /**
     * Documentation:
     * https://www.flickr.com/services/api/flickr.photos.search.html
     */
    const val API_ENDPOINT_ADDRESS = "https://api.flickr.com"
    const val METHOD = "flickr.photos.search"
    const val FORMAT = "json"
    const val PER_PAGE = "20"
    const val MEDIA = "photos"
    const val EXTRAS = "url_h"
    const val SAFE_SEARCH = "1"
    const val NO_JSON_CALLBACK = "1"
}