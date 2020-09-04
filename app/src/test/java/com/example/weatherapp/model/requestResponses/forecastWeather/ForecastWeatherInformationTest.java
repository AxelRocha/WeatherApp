package com.example.weatherapp.model.requestResponses.forecastWeather;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ForecastWeatherInformationTest {

    private ForecastWeatherInformation forecastInformation;
    private ForecastWeatherDescription forecastDescription;

    @Before
    public void setUp(){
        forecastDescription = new ForecastWeatherDescription(
                "Nublado",
                "101"
        );

        forecastInformation = new ForecastWeatherInformation(
                "2020-09-03",
                "20",
                "20",
                "17",
                forecastDescription
        );
    }

    @Test
    public void getValidDate() {
        String validDate = "03/09/2020";
        Assert.assertEquals(validDate, forecastInformation.getValidDate());
    }
}