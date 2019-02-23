# Country Facts
This application simply shows the list of fact about the country we provide. Each fact has below contents

  - Title of the fact
  - Description about the fact
  - Image of the fact
  
 ![Alt text](/screens/Facts.jpg?raw=true "Facts") ![Alt text](/screens/error.jpg?raw=true "Error")
 
 
# Tech Stack
This application is written in Kotlin, have tried to separate the modules as much as possible. For network communication have created separate module called api which is responsible to provide the facts data from network. The idea was to have keep the api related stuff in separate module so that can be used in any other application as well. Think of this module provides set of Facebook API's and have OneToMany client application who can simply use this module to get the facebook api's such as login, friends, messages, photos etc.  

To build this application have used following libraries/pattern
- [Picasso](https://square.github.io/picasso/)
- [Retrofit](https://square.github.io/retrofit/)
- [Dagger](https://google.github.io/dagger/android.html)
- [Android architecture components](https://developer.android.com/topic/libraries/architecture)
- [Mockito](https://site.mockito.org/)
- [Robolectric](http://robolectric.org/)
