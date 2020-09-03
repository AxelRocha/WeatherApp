package com.example.weatherapp.ui.search;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.weatherapp.R;

public class SearchActivity extends AppCompatActivity implements SearchContract.View{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }

    @Override
    public void setPresenter(SearchContract.Presenter presenter) {

    }
}