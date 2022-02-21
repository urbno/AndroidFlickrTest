# AndroidFlickrTest

In this sample application, you can query images from [**flickr api**](https://www.flickr.com/services/api/flickr.photos.search.html), by multiple tags.
Each image has a detail view, which takes the data from the [**flickr api - get info**](https://www.flickr.com/services/api/flickr.photos.getInfo.html) api.

The architecture follows the layered implementation, provided by the [**RainbowCake**](https://github.com/rainbowcake/rainbowcake) framework.
<img src="https://d33wubrfki0l68.cloudfront.net/5c87ced651e328f33727b33bbe9a871e482350a2/63186/images/arch_overview.png" alt="RainbowCake Architecture"/>

### Used libraries
- [**Awesome Dialog**](https://github.com/chnouman/AwesomeDialog) - show messages for the user what causes the error
- [**Glide**](https://github.com/bumptech/glide) - image loading
- [**Motion Toast**](https://github.com/Spikeysanju/MotionToast) - notify the user about the invalid input
- [**Paging3**](https://developer.android.com/topic/libraries/architecture/paging/v3-overview) - load chunk of data
- [**Cardview**](https://developer.android.com/guide/topics/ui/layout/cardview/) - aesthetic detail view
- [**Room database**](https://developer.android.com/training/data-storage/room) - local save of queried data
- [**Retrofit**](https://square.github.io/retrofit/) - network calls
- [**Dagger**](https://dagger.dev/) - dependency injection
- [**Coroutines**](https://github.com/Kotlin/kotlinx.coroutines) - asynchronous execute

### Sample images from the app
<img src="https://raw.githubusercontent.com/urbno/AndroidFlickrTest/main/sample-images/Screenshot_20220221-130906_Android%20Flickr%20Test_framed.png" alt="MainFragment" height=500/><img src="https://github.com/urbno/AndroidFlickrTest/blob/main/sample-images/Screenshot_20220221-130930_Android%20Flickr%20Test_framed.png" alt="DetailsFragment" height=500/><img src="https://github.com/urbno/AndroidFlickrTest/blob/main/sample-images/Screenshot_20220221-130940_Android%20Flickr%20Test_framed.png" alt="Paging loading state" height=500/>
<img src="https://github.com/urbno/AndroidFlickrTest/blob/main/sample-images/Screenshot_20220221-130952_Android%20Flickr%20Test_framed.png" alt="Paging loading error" height=500/><img src="https://github.com/urbno/AndroidFlickrTest/blob/main/sample-images/Screenshot_20220221-131206_Android%20Flickr%20Test_framed.png" alt="Network error dialog" height=500/><img src="https://github.com/urbno/AndroidFlickrTest/blob/main/sample-images/Screenshot_20220221-151452_Android%20Flickr%20Test_framed.png" alt="Invalid user input message" height=500/>
