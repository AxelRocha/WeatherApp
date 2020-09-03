package com.example.weatherapp.ui.details;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.weatherapp.R;
import com.example.weatherapp.model.CurrentWeather;
import com.example.weatherapp.model.ForecastWeather;
import com.example.weatherapp.ui.search.SearchContract;

public class DetailsActivity extends AppCompatActivity implements DetailsContract.View{

    private DetailsContract.Presenter mPresenter;
    private CurrentWeather mCurrentWeather;
    private ForecastWeather mTodayForecasWeather;
    private ForecastWeather mTomorrowForecasWeather;

    private TextView cityWeather;

    private TextView currentTemperature;
    private TextView currentMinTemperature;
    private TextView currentMaxTemperature;
    private TextView currentDescription;

    private TextView forecastMinTemperature;
    private TextView forecastMaxTemperature;
    private TextView forecastDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        mPresenter = new DetailsPresenter(this);

        initViews();
    }

    private void initViews() {

        cityWeather = findViewById(R.id.cityName);

        currentTemperature = findViewById(R.id.currentCelsiusTV);
        currentMinTemperature = findViewById(R.id.minCurrentCelsiusTV);
        currentMaxTemperature = findViewById(R.id.maxCurrentCelsiusTV);
        currentDescription = findViewById(R.id.currentDescription);

        forecastMinTemperature = findViewById(R.id.minForecastCelsiusTV);
        forecastMaxTemperature = findViewById(R.id.maxForecastCelsiusTV);
        forecastDescription = findViewById(R.id.forecastDescription);

    }

    @Override
    public void setPresenter(DetailsContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    protected void onStart() {
        super.onStart();
        mCurrentWeather = (CurrentWeather) getIntent().getSerializableExtra("currentWeather");
        mTodayForecasWeather = (ForecastWeather) getIntent().getSerializableExtra("todayForecastWeather");
        mTomorrowForecasWeather = (ForecastWeather) getIntent().getSerializableExtra("tomorrowForecastWeather");
        populateWeatherInformations(mCurrentWeather, mTodayForecasWeather, mTomorrowForecasWeather);
    }

    private void populateWeatherInformations(CurrentWeather mCurrentWeather, ForecastWeather mTodayForecasWeather,  ForecastWeather mTomorrowForecasWeather) {

        cityWeather.setText("Precisão para a Cidade " + mCurrentWeather.getCity());

        populateCurrentWeatherInformation(mCurrentWeather, mTodayForecasWeather);

        populateForecastWeatherInformation(mTomorrowForecasWeather);
    }

    private void populateForecastWeatherInformation(ForecastWeather mForecastWeather) {
        forecastMinTemperature.setText(mForecastWeather.getMinTemp());
        forecastMaxTemperature.setText(mForecastWeather.getMaxTemp());
        forecastDescription.setText(mForecastWeather.getDescription());
    }

    private void populateCurrentWeatherInformation(CurrentWeather mCurrentWeather, ForecastWeather mForecastWeather) {

        currentTemperature.setText(mCurrentWeather.getTemperature());
        currentMinTemperature.setText(mForecastWeather.getMinTemp());
        currentMaxTemperature.setText(mForecastWeather.getMaxTemp());
        currentDescription.setText(mCurrentWeather.getDescription());

    }
}