package com.example.weatherapp.ui.search;

import android.util.Log;

import com.example.weatherapp.model.CurrentWeather;
import com.example.weatherapp.model.ForecastInformation;
import com.example.weatherapp.model.ForecastWeather;
import com.example.weatherapp.model.requestResponses.currentWeather.CurrentWeatherRequestResponse;
import com.example.weatherapp.model.requestResponses.forecastWeather.ForecastWeatherRequestResponse;
import com.example.weatherapp.network.GetDataService;
import com.example.weatherapp.network.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchPresenter implements SearchContract.Presenter{

    private final SearchContract.View mView;
    private CurrentWeather mCurrentWeather;
    private ForecastWeather mTodayForecastWeather;
    private ForecastWeather mTomorrowForecastWeather;

    public SearchPresenter(SearchContract.View mView) {
        this.mView = mView;
        this.mView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void searchWeather(String city) {

        if (!city.isEmpty()){
            GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);

            getCurrentWeather(city, service);

            getForecastWeather(city, service);

        } else {
            mView.warnEmptyTextView();
        }

        mView.closeKeyboard();
    }

    private void getCurrentWeather(String city, GetDataService service){

        Call<CurrentWeatherRequestResponse> callCurrent = service.getCurrentWeather(city);
        callCurrent.enqueue(new Callback<CurrentWeatherRequestResponse>() {
            @Override
            public void onResponse(Call<CurrentWeatherRequestResponse> call, Response<CurrentWeatherRequestResponse> response) {
                if (response.body() != null){
                    mCurrentWeather = new CurrentWeather(response.body().getData().get(0));
                    onApiResponse();
                }
            }

            @Override
            public void onFailure(Call<CurrentWeatherRequestResponse> call, Throwable t) {
                Log.e("RequestFail","Falha ao chamar currentcast");
                mView.warnErrorOccurred();
            }
        });
    }

    private void getForecastWeather(String city, GetDataService service){

        Call<ForecastWeatherRequestResponse> callForecast = service.getForecastWeather(city);
        callForecast.enqueue(new Callback<ForecastWeatherRequestResponse>() {
            @Override
            public void onResponse(Call<ForecastWeatherRequestResponse> call, Response<ForecastWeatherRequestResponse> response) {
                if (response.body() != null){
                    ForecastInformation forecastInformation = new ForecastInformation(response.body());
                    mTodayForecastWeather = forecastInformation.getTodayForecast();
                    mTomorrowForecastWeather = forecastInformation.getTomorrowForecast();
                    onApiResponse();
                } else {
                    mView.warnCityNotFound();
                }
            }

            @Override
            public void onFailure(Call<ForecastWeatherRequestResponse> call, Throwable t) {
                Log.e("RequestFail","Falha ao chamar forecast");
            }
        });
    }

    private void onApiResponse() {
        if (mCurrentWeather != null && mTodayForecastWeather != null && mTomorrowForecastWeather != null){
            mView.callSearchAcivity(mCurrentWeather, mTodayForecastWeather, mTomorrowForecastWeather);
            mView.clearEditText();
        }
    }
}
