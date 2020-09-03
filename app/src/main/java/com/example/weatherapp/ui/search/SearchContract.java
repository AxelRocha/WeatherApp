package com.example.weatherapp.ui.search;

import com.example.weatherapp.ui.base.BasePresenter;
import com.example.weatherapp.ui.base.BaseView;

public interface SearchContract {

    interface View extends BaseView<SearchContract.Presenter>{
        void callSearchAcivity(CurrentWeather currentWeather, ForecastWeather forecastWeather);

        void closeKeyboard();

        void clearEditText();
    }

    interface Presenter extends BasePresenter{
        void searchWeather(String city);
    }
}
