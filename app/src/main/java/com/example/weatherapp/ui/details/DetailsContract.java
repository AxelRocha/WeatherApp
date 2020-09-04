package com.example.weatherapp.ui.details;

import com.example.weatherapp.ui.base.BasePresenter;
import com.example.weatherapp.ui.base.BaseView;

public interface DetailsContract {

    interface View extends BaseView<DetailsContract.Presenter> {
        void returnToSearchActivity();

        void setCurrentWeatherIcon(int weatherIcon);

        void setForecastWeatherIcon(int weatherIcon);
    }

    interface Presenter extends BasePresenter {
        void redoSearch();

        void getWeatherIcon(int code, boolean isForecast);

    }
}
