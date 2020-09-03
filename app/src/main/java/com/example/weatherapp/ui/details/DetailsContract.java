package com.example.weatherapp.ui.details;

import com.example.weatherapp.model.CurrentWeather;
import com.example.weatherapp.model.ForecastWeather;
import com.example.weatherapp.ui.base.BasePresenter;
import com.example.weatherapp.ui.base.BaseView;
import com.example.weatherapp.ui.search.SearchContract;

public interface DetailsContract {

    interface View extends BaseView<DetailsContract.Presenter> {
    }

    interface Presenter extends BasePresenter {
    }
}
