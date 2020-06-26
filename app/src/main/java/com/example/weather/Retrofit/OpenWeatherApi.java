package com.example.weather.Retrofit;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class OpenWeatherApi {

    @SerializedName("main")
    private Main main;

    @SerializedName("weather")
    private ArrayList<Weather> weatherList;

    @SerializedName("name")
    private String name;

    public Main getMain() {
        return main;
    }
    public void setMain(Main main) {
        this.main = main;
    }

    public ArrayList<Weather> getWeatherList() {
        return weatherList;
    }

    public void setWeatherList(ArrayList<Weather> weatherList) {
        this.weatherList = weatherList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
