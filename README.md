# Point of Interest App

## Android Studio version
Dolphin 2021.3.1

## Installation
1. Launch Android Studio
2. Go to the Git option
3. Copy the following link: https://github.com/Ollez95/PointOfInterestApp into the clone option.
4. Ensure that your Github token is up-to-date in Android Studio.

## Overview of the Application

This application is a simple and straightforward app developed using Kotlin and Jetpack Compose. It consists of two main views:
- Main View: You can access this view by selecting a button, which will call the API https://sergiocasero.es/pois.json. This will retrieve data from a remote repository and save it to a local repository.
- Detail View: This view displays detailed information about stadiums, such as a picture of the stadium and its location on Google Maps.

## Google Maps API
To utilize the Google Maps feature in this application, follow these steps:
1. Open the AndroidManifest.xml file.
2. Update the following line with your API key: 
```xml 
<meta-data android:name="com.google.android.geo.API_KEY" android:value="API_KEY">
```
       
