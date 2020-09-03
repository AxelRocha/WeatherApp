package com.example.weatherapp.model;

import com.example.weatherapp.model.requestResponses.forecastWeather.ForecastWeatherRequestResponse;

import java.io.Serializable;

public class ForecastWeather implements Serializable {
    private String validDate;
    private String city;
    private String state;
    private String maxTemp;
    private String minTemp;
    private String probPrecipitation;
    private String description;

    public ForecastWeather(String validDate, String city, String state, String maxTemp, String minTemp, String probPrecipitation, String description) {
        this.validDate = validDate;
        this.city = city;
        this.state = state;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.probPrecipitation = probPrecipitation;
        this.description = description;
    }

    public String getValidDate() {
        return validDate;
    }

    public void setValidDate(String validDate) {
        this.validDate = validDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(String maxTemp) {
        this.maxTemp = maxTemp;
    }

    public String getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(String minTemp) {
        this.minTemp = minTemp;
    }

    public String getProbPrecipitation() {
        return probPrecipitation;
    }

    public void setProbPrecipitation(String probPrecipitation) {
        this.probPrecipitation = probPrecipitation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
