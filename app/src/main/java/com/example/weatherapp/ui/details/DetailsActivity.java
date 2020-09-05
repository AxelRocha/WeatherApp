package com.example.weatherapp.ui.details;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.weatherapp.R;
import com.example.weatherapp.model.CurrentWeather;
import com.example.weatherapp.model.ForecastWeather;

import java.io.IOException;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class DetailsActivity extends AppCompatActivity implements DetailsContract.View{

    private DetailsContract.Presenter mPresenter;
    private CurrentWeather mCurrentWeather;
    private ForecastWeather mTodayForecasWeather;
    private ForecastWeather mTomorrowForecasWeather;

    private TextView cityWeather;

    private TextView currentDate;
    private TextView currentTemperature;
    private TextView currentMinTemperature;
    private TextView currentMaxTemperature;
    private TextView currentDescription;
    private ImageView currentWeatherIcon;
    private GifImageView currentGif;

    private TextView forecastDate;
    private TextView forecastMinTemperature;
    private TextView forecastMaxTemperature;
    private TextView forecastDescription;
    private ImageView forecastWeatherIcon;
    private GifImageView forecastGif;

    private Button redoSearchBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        mPresenter = new DetailsPresenter(this);

        initViews();

        redoSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.redoSearch();
            }
        });
    }

    private void initViews() {

        cityWeather = findViewById(R.id.cityName);

        currentDate = findViewById(R.id.currentDateTV);
        currentTemperature = findViewById(R.id.currentCelsiusTV);
        currentMinTemperature = findViewById(R.id.minCurrentCelsiusTV);
        currentMaxTemperature = findViewById(R.id.maxCurrentCelsiusTV);
        currentDescription = findViewById(R.id.currentDescription);
        currentWeatherIcon = findViewById(R.id.currentWeatherIcon);
        currentGif = findViewById(R.id.gifCurrent);

        forecastDate = findViewById(R.id.forecastDayTV);
        forecastMinTemperature = findViewById(R.id.minForecastCelsiusTV);
        forecastMaxTemperature = findViewById(R.id.maxForecastCelsiusTV);
        forecastDescription = findViewById(R.id.forecastDescription);
        forecastWeatherIcon = findViewById(R.id.forecasttWeatherIcon);
        forecastGif = findViewById(R.id.gifForecast);

        redoSearchBtn = findViewById(R.id.redoSearch);

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

        String location ="Previsão para " + mTodayForecasWeather.getCity();
        cityWeather.setText(location);

        populateCurrentWeatherInformation(mCurrentWeather, mTodayForecasWeather);

        populateForecastWeatherInformation(mTomorrowForecasWeather);
    }

    private void populateCurrentWeatherInformation(CurrentWeather mCurrentWeather, ForecastWeather mForecastWeather) {

        String currentDate = "Hoje (" + mForecastWeather.getValidDate() + ")";
        this.currentDate.setText(currentDate);

        mPresenter.getWeatherIcon(Integer.parseInt(mCurrentWeather.getWeatherCode()), false);

        currentTemperature.setText(mCurrentWeather.getTemperature() + " °C");
        currentMinTemperature.setText(mForecastWeather.getMinTemp()+ " °C");
        currentMaxTemperature.setText(mForecastWeather.getMaxTemp()+ " °C");
        currentDescription.setText(mCurrentWeather.getDescription());

    }

    private void populateForecastWeatherInformation(ForecastWeather mForecastWeather) {

        String currentDate = "Amanhã (" + mForecastWeather.getValidDate() + ")";
        this.forecastDate.setText(currentDate);

        mPresenter.getWeatherIcon(Integer.parseInt(mForecastWeather.getWeatherCode()), true);

        forecastMinTemperature.setText(mForecastWeather.getMinTemp()+ " °C");
        forecastMaxTemperature.setText(mForecastWeather.getMaxTemp()+ " °C");
        forecastDescription.setText(mForecastWeather.getDescription());

    }

    @Override
    public void returnToSearchActivity() {
        finish();
    }

    @Override
    public void setCurrentWeatherIcon(int weatherIcon) {
        currentWeatherIcon.setBackgroundResource(weatherIcon);
    }

    @Override
    public void setForecastWeatherIcon(int weatherIcon) {
        forecastWeatherIcon.setBackgroundResource(weatherIcon);
    }

    @Override
    public void setCurrentWeatherBackground(int weatherBackground) {
        try {
            GifDrawable gif = new GifDrawable(getResources(), weatherBackground);
            gif.setCornerRadius(40);
            currentGif.setBackground(gif);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setForecastWeatherBackground(int weatherBackground) {
        try {
            GifDrawable gif = new GifDrawable(getResources(), weatherBackground);
            gif.setCornerRadius(40);
            forecastGif.setBackground(gif);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}