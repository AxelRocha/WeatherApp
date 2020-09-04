package com.example.weatherapp.model.requestResponses.currentWeather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CurrentWeatherInformation{
    @SerializedName("city_name")
    @Expose
    private String city;

    @SerializedName("temp")
    @Expose
    private String temperature;

    @SerializedName("weather")
    @Expose
    private CurrentWeatherDescription currentWeatherDescription;

    public CurrentWeatherInformation(String city, String temperature, CurrentWeatherDescription currentWeatherDescription) {
        this.city = city;
        this.temperature = temperature;
        this.currentWeatherDescription = currentWeatherDescription;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public CurrentWeatherDescription getCurrentWeatherDescription() {
        return currentWeatherDescription;
    }

    public void setCurrentWeatherDescription(CurrentWeatherDescription currentWeatherDescription) {
        this.currentWeatherDescription = currentWeatherDescription;
    }
}