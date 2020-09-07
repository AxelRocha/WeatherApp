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

        String location = getResources().getString(R.string.forecast_to, mCurrentWeather.getCity());
        cityWeather.setText(location);

        populateCurrentWeatherInformation(mCurrentWeather, mTodayForecasWeather);

        populateForecastWeatherInformation(mTomorrowForecasWeather);
    }

    private void populateCurrentWeatherInformation(CurrentWeather mCurrentWeather, ForecastWeather mForecastWeather) {

        String currentDate = getResources().getString(R.string.today, mForecastWeather.getValidDate());
        this.currentDate.setText(currentDate);

        currentTemperature.setText(getResources().getString(R.string.weather_celsius, mCurrentWeather.getTemperature()));
        currentMinTemperature.setText(getResources().getString(R.string.weather_celsius, mForecastWeather.getMinTemp()));
        currentMaxTemperature.setText(getResources().getString(R.string.weather_celsius, mForecastWeather.getMaxTemp()));
        currentDescription.setText(mCurrentWeather.getDescription());
        currentWeatherIcon.setBackgroundResource(mCurrentWeather.getWeatherIcon());
        setWeatherGif(currentGif, mCurrentWeather.getWeatherBackground());


    }

    private void populateForecastWeatherInformation(ForecastWeather mForecastWeather) {

        String currentDate = getResources().getString(R.string.tomorrow, mForecastWeather.getValidDate());
        this.forecastDate.setText(currentDate);

        forecastMinTemperature.setText(getResources().getString(R.string.weather_celsius, mForecastWeather.getMinTemp()));
        forecastMaxTemperature.setText(getResources().getString(R.string.weather_celsius, mForecastWeather.getMaxTemp()));
        forecastDescription.setText(mForecastWeather.getDescription());
        forecastWeatherIcon.setBackgroundResource(mForecastWeather.getWeatherIcon());
        setWeatherGif(forecastGif, mForecastWeather.getWeatherBackground());

    }

    private void setWeatherGif(GifImageView weatherGif, int weatherBackground) {

        try {
            GifDrawable gif = new GifDrawable(getResources(), weatherBackground);
            gif.setCornerRadius(40);
            weatherGif.setBackground(gif);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void returnToSearchActivity() {
        finish();
    }
}