package com.example.weatherapp.model;

public class WeatherAssets {
    private int weatherIcon;
    private int weatherBackground;

    public WeatherAssets(int weatherIcon, int weatherBackground) {
        this.weatherIcon = weatherIcon;
        this.weatherBackground = weatherBackground;
    }

    public WeatherAssets() {
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
