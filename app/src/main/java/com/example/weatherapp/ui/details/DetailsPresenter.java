package com.example.weatherapp.ui.details;

import com.example.weatherapp.model.CurrentWeather;
import com.example.weatherapp.ui.search.SearchContract;

public class DetailsPresenter implements DetailsContract.Presenter {

    private final DetailsContract.View mView;

    public DetailsPresenter(DetailsContract.View mView) {
        this.mView = mView;
        this.mView.setPresenter(this);
    }

    @Override
    public void start() {

    }
}
