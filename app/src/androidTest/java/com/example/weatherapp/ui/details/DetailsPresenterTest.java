package com.example.weatherapp.ui.details;

import com.example.weatherapp.model.WeatherAssets;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Calendar;

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
}