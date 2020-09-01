package com.example.weatherapp.network;

import com.example.weatherapp.model.requestResponses.currentWeather.CurrentWeatherResquestResponse;
import com.example.weatherapp.model.requestResponses.forecastWeather.ForecastWeatherRequestResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetDataService {
    String LANGUAGE = "&lang=pt";
    String COUNTRY = "&country=BR";
    String API_KEY = "&key=bdd8b14584ad4b719c14a86c59d9987a";

    @GET("current?" + COUNTRY + LANGUAGE + API_KEY)
    Call<CurrentWeatherResquestResponse> getCurrentWeather(@Query("city") String city);

    @GET("forecast/daily?" + COUNTRY + LANGUAGE + API_KEY)
    Call<ForecastWeatherRequestResponse> getForecastWeather(@Query("city") String city);
}
