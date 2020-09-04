package com.example.weatherapp.ui.details;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class DetailsPresenterTest {

    @Mock
    private DetailsContract.View view;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void redoSearch() {
        DetailsPresenter presenter = new DetailsPresenter(view);

        presenter.redoSearch();

        verify(view, times(1)).returnToSearchActivity();
    }

    @Test
    public void getCurrentWeatherIcon() {
        DetailsPresenter presenter = new DetailsPresenter(view);

        presenter.getWeatherIcon(anyInt(), false);

        verify(view, times(1)).setCurrentWeatherIcon(anyInt());
        verify(view, times(0)).setForecastWeatherIcon(anyInt());
    }

    @Test
    public void getForecastWeatherIcon() {
        DetailsPresenter presenter = new DetailsPresenter(view);

        presenter.getWeatherIcon(anyInt(), true);

        verify(view, times(0)).setCurrentWeatherIcon(anyInt());
        verify(view, times(1)).setForecastWeatherIcon(anyInt());
    }

}