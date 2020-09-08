package com.example.weatherapp.model;

import java.io.Serializable;

public class ForecastWeather implements Serializable {

    private String validDate;
    private String city;
    private String state;
    private String maxTemp;
    private String minTemp;
    private String probPrecipitation;
    private String description;
    private String weatherCode;
    private int weatherIcon;
    private int weatherBackground;

    public ForecastWeather(String validDate, String city, String state, String maxTemp, String minTemp, String probPrecipitation, String description, String weatherCode) {
        this.validDate = validDate;
        this.city = city;
        this.state = state;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.probPrecipitation = probPrecipitation;
        this.description = description;
        this.weatherCode = weatherCode;
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

    public String getWeatherCode() {
        return weatherCode;
    }

    public void setWeatherCode(String weatherCode) {
        this.weatherCode = weatherCode;
    }

    public int getWeatherIcon() {
        return weatherIcon;
    }

    public void setWeatherIcon(int weatherIcon) {
        this.weatherIcon = weatherIcon;
    }

    public int getWeatherBackground() {
        return weatherBackground;
    }

    public void setWeatherBackground(int weatherBackground) {
        this.weatherBackground = weatherBackground;
    }
}
