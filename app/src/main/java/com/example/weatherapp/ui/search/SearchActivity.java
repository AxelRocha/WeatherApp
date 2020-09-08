package com.example.weatherapp.ui.search;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.weatherapp.R;
import com.example.weatherapp.model.CurrentWeather;
import com.example.weatherapp.model.ForecastWeather;
import com.example.weatherapp.network.GetDataService;
import com.example.weatherapp.network.RetrofitClientInstance;
import com.example.weatherapp.ui.details.DetailsActivity;

public class SearchActivity extends AppCompatActivity implements SearchContract.View{

    private SearchContract.Presenter mPresenter;

    private EditText searchEditText;
    private Button searchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        mPresenter =  new SearchPresenter(this);

        initViews();

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                mPresenter.searchWeather(searchEditText.getText().toString(), service);
            }
        });
    }

    private void initViews() {

        searchEditText = findViewById(R.id.searchEditText);
        searchBtn = findViewById(R.id.searchBtn);
    }

    @Override
    public void setPresenter(SearchContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void callSearchAcivity(CurrentWeather currentWeather, ForecastWeather todayForecastWeather, ForecastWeather tomorrowForecastWeather) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("currentWeather", currentWeather);
        intent.putExtra("todayForecastWeather", todayForecastWeather);
        intent.putExtra("tomorrowForecastWeather", tomorrowForecastWeather);
        startActivity(intent);
    }

    @Override
    public void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null){
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    public void clearEditText() {
        searchEditText.setText("");
    }

    @Override
    public void warnEmptyTextView() {
        Toast.makeText(this, R.string.warn_empy_text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void warnCityNotFound() {
        Toast.makeText(this, R.string.warn_city_not_found, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void warnErrorOccurred() {
        Toast.makeText(this, R.string.warn_error_occurred, Toast.LENGTH_SHORT).show();
    }
}