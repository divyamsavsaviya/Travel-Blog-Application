# TravelBlog

I have created a Travel Blog Application which consists of login screen where you can enter your details and log in after login successfully it will redirect to blog list screen where you can see a list of blog articles which loaded from internet from JSON file, at blog list screen user can use feature like search, filter or click to open blog details screen where user can check more details about particular blog
## Features

- login and validation of user. After successfully login data will stored in SharedPreferences.
- Loading data from internet using HTTP client from json file and parsing that data in to java objects.
- After loading data successfully showing list as showed in blog list screen if data is not loaded successfully by any reason application will show snack bar error and give option to load data again. 
- User can search and filter data from search button in tool bar.
- User can sort list by blog Title or by blog date.
- User can see more about blog by clicking on blog list item which is done by parsing that java object to blog screen activity.
- At blog screen data is again load from internet and showed all the field according to blog if data is not loaded successfully by any reason application will show snack bar error and give option to load data again.
- Once data is loaded the whole data will be stored locally.
- From now whenever user will open application data will be retrieved from locally.

## Tech

- [Okhttp] -  Exchange data & media!
- [Gson] - Convert a JSON string to an equivalent Java object.
- [Glide] - Media management and image loading framework

## Dependencies

Add This Dependencies in your app level build file

```sh
    // Glide for loading image
    implementation 'com.github.bumptech.glide:glide:4.10.0'
    // Okhttp for data exchange from the Internet
    implementation 'com.squareup.okhttp3:okhttp:4.2.1'
    // To convert the JSON string to an equivalent Java objects
    implementation 'com.google.code.gson:gson:2.8.6'
    // swipe refresh layout
    implementation "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0"
    implementation "androidx.room:room-runtime:2.3.0"
    annotationProcessor "androidx.room:room-compiler:2.3.0"
```


[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)

   [Okhttp]: <https://square.github.io/okhttp/>
   [Gson]: <https://github.com/google/gson>
   [Glide]: <https://github.com/bumptech/glide>
