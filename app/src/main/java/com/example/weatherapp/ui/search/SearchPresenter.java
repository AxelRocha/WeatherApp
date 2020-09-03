package com.example.weatherapp.ui.search;

import android.util.Log;

import com.example.weatherapp.model.CurrentWeather;
import com.example.weatherapp.model.ForecastWeather;
import com.example.weatherapp.model.requestResponses.currentWeather.CurrentWeatherResquestResponse;
import com.example.weatherapp.model.requestResponses.forecastWeather.ForecastWeatherRequestResponse;
import com.example.weatherapp.network.GetDataService;
import com.example.weatherapp.network.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchPresenter implements SearchContract.Presenter{

    private final SearchContract.View mView;
    private CurrentWeather mCurrentWeather;
    ForecastWeather mForecastWeather;

    public SearchPresenter(SearchContract.View mView) {
        this.mView = mView;
        this.mView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void searchWeather(String city) {
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);

        getCurrentWeather(city, service);

        getForecastWeather(city, service);

        mView.closeKeyboard();
    }

    private void getCurrentWeather(String city, GetDataService service){

        Call<CurrentWeatherResquestResponse> callCurrent = service.getCurrentWeather(city);
        callCurrent.enqueue(new Callback<CurrentWeatherResquestResponse>() {
            @Override
            public void onResponse(Call<CurrentWeatherResquestResponse> call, Response<CurrentWeatherResquestResponse> response) {
                if (response.body() != null){
                    mCurrentWeather = new CurrentWeather(response.body().getData().get(0));
                    onApiResponse();
                }
            }

            @Override
            public void onFailure(Call<CurrentWeatherResquestResponse> call, Throwable t) {
                onApiResponse();
            }
        });
    }

    private void getForecastWeather(String city, GetDataService service){

        Call<ForecastWeatherRequestResponse> callForecast = service.getForecastWeather(city);
        callForecast.enqueue(new Callback<ForecastWeatherRequestResponse>() {
            @Override
            public void onResponse(Call<ForecastWeatherRequestResponse> call, Response<ForecastWeatherRequestResponse> response) {
                if (response.body() != null){
                    mForecastWeather = new ForecastWeather(response.body());
                    onApiResponse();
                }
            }

            @Override
            public void onFailure(Call<ForecastWeatherRequestResponse> call, Throwable t) {
                onApiResponse();
            }
        });
    }

    private void onApiResponse() {
        if (mCurrentWeather != null && mForecastWeather != null){
            mView.callSearchAcivity(mCurrentWeather, mForecastWeather);
            mView.clearEditText();
        }
    }
}
