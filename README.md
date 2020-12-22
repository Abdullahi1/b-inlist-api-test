# api-test
BINLIST.NET query api in kotlin

###Overview
BInlist Api is a demo application that uses MVVM pattern and Android Jetpack: ViewModel, LiveData, Dagger-Hilt and Navigations Components.
The app fetches data from the network with use of Retrofit. The app also uses and Kotlin Coroutines.

###Third Party
 - Kotlin Coroutines for managing background threads with simplified code and reducing needs for callbacks
 - Retrofit2 & OkHttp3 - to make REST requests to the web service integrated.
 - Moshi to handle the deserialization of the returned JSON to Kotlin data objects.
 - Timber for logs.

### Architecture:
  - MVVM Architecture
  - Repository pattern
  - Clean Architecture


## Testing
### Local Unit Tests:
  - <b>Repository Tests</b> - Repository is tested using local unit tests with mock versions of Service and Usecases.
