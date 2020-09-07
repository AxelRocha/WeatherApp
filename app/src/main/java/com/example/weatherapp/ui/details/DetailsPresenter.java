package com.example.weatherapp.ui.details;

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
}
