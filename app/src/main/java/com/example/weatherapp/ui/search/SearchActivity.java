package com.example.weatherapp.ui.search;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.weatherapp.R;
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

        searchEditText = findViewById(R.id.searchEditText);
        searchBtn = findViewById(R.id.searchBtn);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.searchWeather(searchEditText.getText().toString());
            }
        });
    }

    @Override
    public void setPresenter(SearchContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void callSearchAcivity(String city) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("cityName", city);
        startActivity(intent);
    }
}