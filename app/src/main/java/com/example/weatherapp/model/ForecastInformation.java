package com.example.weatherapp.model;

import com.example.weatherapp.model.requestResponses.forecastWeather.ForecastWeatherRequestResponse;

public class ForecastInformation {
    ForecastWeatherRequestResponse forecastInformation;
    private String city;
    private String state;
    private String country;

    public ForecastInformation(ForecastWeatherRequestResponse forecastInformation) {
        this.forecastInformation = forecastInformation;
        this.city = forecastInformation.getCity();
        this.state = forecastInformation.getState();
        this.country = forecastInformation.getCountry();
    }

    public ForecastWeather getTodayForecast(){
        return new ForecastWeather(
                this.forecastInformation.getData().get(0).getValidDate(),
                this.forecastInformation.getData().get(0).getMaxTemp(),
                this.forecastInformation.getData().get(0).getMinTemp(),
                this.forecastInformation.getData().get(0).getProbPrecipitation(),
                this.forecastInformation.getData().get(0).getForecastWeatherDescription().getDescription()
        );
    }

    public ForecastWeather getTomorrowForecast(){
        return new ForecastWeather(
                this.forecastInformation.getData().get(1).getValidDate(),
                this.forecastInformation.getData().get(1).getMaxTemp(),
                this.forecastInformation.getData().get(1).getMinTemp(),
                this.forecastInformation.getData().get(1).getProbPrecipitation(),
                this.forecastInformation.getData().get(1).getForecastWeatherDescription().getDescription()
        );
    }

    public ForecastWeatherRequestResponse getForecastInformation() {
        return forecastInformation;
    }

    public void setForecastInformation(ForecastWeatherRequestResponse forecastInformation) {
        this.forecastInformation = forecastInformation;
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
}
