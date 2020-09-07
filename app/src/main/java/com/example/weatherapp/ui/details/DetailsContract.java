package com.example.weatherapp.ui.details;

import com.example.weatherapp.model.CurrentWeather;
import com.example.weatherapp.model.ForecastWeather;
import com.example.weatherapp.ui.base.BasePresenter;
import com.example.weatherapp.ui.base.BaseView;

public interface DetailsContract {

    interface View extends BaseView<DetailsContract.Presenter> {
        void returnToSearchActivity();

        void populateCurrentWeatherInformation(CurrentWeather mCurrentWeather, ForecastWeather mForecastWeather);

        void populateForecastWeatherInformation(ForecastWeather mForecastWeather);
    }

    interface Presenter extends BasePresenter {
        void redoSearch();

        void populateWeatherInformations(CurrentWeather mCurrentWeather, ForecastWeather mTodayForecasWeather, ForecastWeather mTomorrowForecasWeather);
    }
}
