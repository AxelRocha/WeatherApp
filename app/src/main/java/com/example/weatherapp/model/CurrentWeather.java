package com.example.weatherapp.model;

import com.example.weatherapp.model.requestResponses.currentWeather.CurrentWeatherResquestResponse.*;

import java.io.Serializable;

public class CurrentWeather implements Serializable {

    private String city;
    private String description;
    private String temperature;

    public CurrentWeather(CurrentWeatherInformation information) {
        this.city = information.getCity();
        this.description = information.getCurrentWeatherDescription().getDescription();
        this.temperature = information.getTemperature();
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
}
