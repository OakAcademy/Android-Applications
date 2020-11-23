package com.ongel.weatherapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherAPI {

    @GET("weather?appid=f247e252b56aea820fc0cb7527712490&units=metric")
    Call<OpenWeathwerMap> getWeatherWithLocation(@Query("lat")double lat, @Query("lon")double lon);

    @GET("weather?appid=f247e252b56aea820fc0cb7527712490&units=metric")
    Call<OpenWeathwerMap>getWeatherWithCityName(@Query("q")String name);
}
