package com.example.weatherapp.model;

import com.example.weatherapp.model.requestResponses.currentWeather.CurrentWeatherInformation;

import java.io.Serializable;

public class CurrentWeather implements Serializable {

    private String city;
    private String description;
    private String temperature;
    private String weatherCode;

    public CurrentWeather(CurrentWeatherInformation information) {
        this.city = information.getCity();
        this.temperature = information.getTemperature();
        this.description = information.getCurrentWeatherDescription().getDescription();
        this.weatherCode = information.getCurrentWeatherDescription().getWeatherCode();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWeatherCode() {
        return weatherCode;
    }

    public void setWeatherCode(String weatherCode) {
        this.weatherCode = weatherCode;
    }
}
