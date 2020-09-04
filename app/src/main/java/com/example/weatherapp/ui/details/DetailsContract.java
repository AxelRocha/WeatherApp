package com.example.weatherapp.ui.details;

import com.example.weatherapp.ui.base.BasePresenter;
import com.example.weatherapp.ui.base.BaseView;

public interface DetailsContract {

    interface View extends BaseView<DetailsContract.Presenter> {
    }

    interface Presenter extends BasePresenter {
    }
}
