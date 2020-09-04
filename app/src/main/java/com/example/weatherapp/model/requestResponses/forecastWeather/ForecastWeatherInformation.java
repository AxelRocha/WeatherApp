package com.example.weatherapp.model.requestResponses.forecastWeather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ForecastWeatherInformation{
    @SerializedName("valid_date")
    @Expose
    private String validDate;

    @SerializedName("max_temp")
    @Expose
    private String maxTemp;

    @SerializedName("min_temp")
    @Expose
    private String minTemp;

    @SerializedName("pop")
    @Expose
    private String probPrecipitation;

    @SerializedName("weather")
    @Expose
    private ForecastWeatherDescription forecastWeatherDescription;

    public ForecastWeatherInformation(String validDate, String maxTemp, String minTemp, String probPrecipitation, ForecastWeatherDescription forecastWeatherDescription) {
        this.validDate = validDate;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.probPrecipitation = probPrecipitation;
        this.forecastWeatherDescription = forecastWeatherDescription;
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

    public ForecastWeatherDescription getForecastWeatherDescription() {
        return forecastWeatherDescription;
    }

    public void setForecastWeatherDescription(ForecastWeatherDescription forecastWeatherDescription) {
        this.forecastWeatherDescription = forecastWeatherDescription;
    }

    public String getValidDate() {

        try {
            Date date =new SimpleDateFormat("yyyy-MM-dd").parse(validDate);

            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
            validDate = formatador.format(date);

        } catch (ParseException ignored){
        }

        return validDate;
    }
}
