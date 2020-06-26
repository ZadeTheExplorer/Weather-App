package com.example.weather.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    //TODO: change APIKey latter
    @GET("weather?,uk&APPID=92756c24107bc39dd0a7541f66ba55c5&units=metric")
    Call<OpenWeatherApi> getWeatherData(@Query("q") String name);
}
