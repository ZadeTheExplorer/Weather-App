package com.example.weather.Retrofit;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Weather {
    @SerializedName("description")
    String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
