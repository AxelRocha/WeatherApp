package com.example.weatherapp.model.requestResponses.forecastWeather;

import com.example.weatherapp.model.ForecastWeather;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ForecastWeatherRequestResponse {
    @SerializedName("city_name")
    @Expose
    private String city;

    @SerializedName("state_code")
    @Expose
    private String state;

    @SerializedName("country_code")
    @Expose
    private String country;

    @SerializedName("data")
    @Expose
    private List<ForecastWeatherInformation> data;

    public ForecastWeatherRequestResponse(String city, String state, String country, List<ForecastWeatherInformation> data) {
        this.city = city;
        this.state = state;
        this.country = country;
        this.data = data;
    }

    public ForecastWeatherRequestResponse() {
    }

    public ForecastWeather getTodayForecast(){
        return new ForecastWeather(
                this.data.get(0).getValidDate(),
                this.city,
                this.state,
                this.data.get(0).getMaxTemp(),
                this.data.get(0).getMinTemp(),
                this.data.get(0).getProbPrecipitation(),
                this.data.get(0).getForecastWeatherDescription().getDescription(),
                this.data.get(0).getForecastWeatherDescription().getWeatherCode()
        );
    }

    public ForecastWeather getTomorrowForecast(){
        return new ForecastWeather(
                this.data.get(1).getValidDate(),
                this.city,
                this.state,
                this.data.get(1).getMaxTemp(),
                this.data.get(1).getMinTemp(),
                this.data.get(1).getProbPrecipitation(),
                this.data.get(1).getForecastWeatherDescription().getDescription(),
                this.data.get(1).getForecastWeatherDescription().getWeatherCode()
        );
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

    public List<ForecastWeatherInformation> getData() {
        return data;
    }

    public void setData(List<ForecastWeatherInformation> data) {
        this.data = data;
    }
}
