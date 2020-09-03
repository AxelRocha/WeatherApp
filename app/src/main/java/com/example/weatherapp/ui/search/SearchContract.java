package com.example.weatherapp.ui.search;

import com.example.weatherapp.ui.base.BasePresenter;
import com.example.weatherapp.ui.base.BaseView;

public interface SearchContract {

    interface View extends BaseView<SearchContract.Presenter>{
        void callSearchAcivity(String city);
    }

    interface Presenter extends BasePresenter{
        void searchWeather(String city);
    }
}
