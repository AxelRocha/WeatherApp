package com.example.weatherapp.ui.search;

import com.example.weatherapp.model.requestResponses.currentWeather.CurrentWeatherRequestResponse;
import com.example.weatherapp.model.requestResponses.forecastWeather.ForecastWeatherRequestResponse;
import com.example.weatherapp.network.GetDataService;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import retrofit2.Call;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SearchPresenterTest {

    @Mock
    private SearchContract.View view;

    @Mock
    private GetDataService retrofit;

    @Mock
    private Call<CurrentWeatherRequestResponse> currentCall;

    @Mock
    private Call<ForecastWeatherRequestResponse> forecastCall;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void searchWeather_Input() {
        SearchPresenter presenter = new SearchPresenter(view);

        when(retrofit.getCurrentWeather(anyString())).thenReturn(currentCall);

        when(retrofit.getForecastWeather(anyString())).thenReturn(forecastCall);

        presenter.searchWeather("Cuiaba", retrofit);

        verify(retrofit, times(1)).getCurrentWeather("Cuiaba");
    }

    @Test
    public void searchWeather_EmptyIput() {
        SearchPresenter presenter = new SearchPresenter(view);

        when(retrofit.getCurrentWeather(anyString())).thenReturn(currentCall);

        when(retrofit.getForecastWeather(anyString())).thenReturn(forecastCall);

        presenter.searchWeather("", retrofit);

        verify(retrofit, times(0)).getCurrentWeather("");
    }
}