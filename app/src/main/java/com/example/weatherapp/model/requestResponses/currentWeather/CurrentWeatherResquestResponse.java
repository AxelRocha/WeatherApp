package com.example.weatherapp.model.requestResponses.currentWeather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CurrentWeatherResquestResponse {
    @SerializedName("data")
    @Expose
    private List<CurrentWeatherInformation> data;

    public List<CurrentWeatherInformation> getData() {
        return data;
    }

    public void setData(List<CurrentWeatherInformation> data) {
        this.data = data;
    }

    public CurrentWeatherResquestResponse(List<CurrentWeatherInformation> data) {
        this.data = data;
    }

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

    public class CurrentWeatherDescription{
        @SerializedName("description")
        @Expose
        private String description;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public CurrentWeatherDescription(String description) {
            this.description = description;
        }
    }
}
