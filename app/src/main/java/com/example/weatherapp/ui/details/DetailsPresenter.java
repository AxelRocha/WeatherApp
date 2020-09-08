package com.example.weatherapp.ui.details;

import com.example.weatherapp.model.CurrentWeather;
import com.example.weatherapp.model.ForecastWeather;

public class DetailsPresenter implements DetailsContract.Presenter {

    private final DetailsContract.View mView;

    public DetailsPresenter(DetailsContract.View mView) {
        this.mView = mView;
        this.mView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void redoSearch() {
        mView.returnToSearchActivity();
    }

    @Override
    public void populateWeatherInformations(CurrentWeather mCurrentWeather, ForecastWeather mTodayForecasWeather, ForecastWeather mTomorrowForecasWeather) {
        mView.populateCurrentWeatherInformation(mCurrentWeather, mTodayForecasWeather);
        mView.populateForecastWeatherInformation(mTomorrowForecasWeather);
    }
}
