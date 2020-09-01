package com.example.weatherapp.model;

import com.example.weatherapp.model.requestResponses.forecastWeather.ForecastWeatherRequestResponse;

public class ForecastWeather {
    private String city;
    private String state;
    private String country;
    private String validDate;
    private String maxTemp;
    private String minTemp;
    private String probPrecipitation;
    private String description;

    public ForecastWeather(ForecastWeatherRequestResponse information) {
        this.city = information.getCity();
        this.state = information.getState();
        this.country = information.getCountry();
        this.validDate = information.getData().get(1).getValidDate();
        this.maxTemp = information.getData().get(1).getMaxTemp();
        this.minTemp = information.getData().get(1).getMinTemp();
        this.probPrecipitation = information.getData().get(1).getProbPrecipitation();
        this.description = information.getData().get(1).getForecastWeatherDescription().getDescription();
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getValidDate() {
        return validDate;
    }

    public void setValidDate(String validDate) {
        this.validDate = validDate;
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
