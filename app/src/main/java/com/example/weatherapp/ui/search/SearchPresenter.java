package com.example.weatherapp.ui.search;

public class SearchPresenter implements SearchContract.Presenter{

    private final SearchContract.View mView;

    public SearchPresenter(SearchContract.View mView) {
        this.mView = mView;
        this.mView.setPresenter(this);
    }

    @Override
    public void start() {

    }
}
