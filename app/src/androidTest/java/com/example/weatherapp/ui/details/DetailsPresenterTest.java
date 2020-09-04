package com.example.weatherapp.ui.details;

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

    @Test
    public void getSunnyIcon() {
        DetailsPresenter presenter = new DetailsPresenter(view);
        int icon = 0;

        icon = presenter.getSunnyIcon(800, true);

        Assert.assertNotEquals(0,icon);
    }

    @Test
    public void getCloudyIcon() {
        DetailsPresenter presenter = new DetailsPresenter(view);
        int icon = 0;

        icon = presenter.getCloudyIcon(700, false);

        Assert.assertNotEquals(0,icon);
    }

    @Test
    public void getSnowIcon() {
        DetailsPresenter presenter = new DetailsPresenter(view);
        int icon = 0;

        icon = presenter.getSnowIcon(600, false);

        Assert.assertNotEquals(0,icon);
    }

    @Test
    public void getRainIcon() {
        DetailsPresenter presenter = new DetailsPresenter(view);
        int icon = 0;

        icon = presenter.getRainIcon(500, false);

        Assert.assertNotEquals(0,icon);
    }

    @Test
    public void getDrizzleIcon() {
        DetailsPresenter presenter = new DetailsPresenter(view);
        int icon = 0;

        icon = presenter.getDrizzleIcon(300,false);

        Assert.assertNotEquals(0,icon);
    }


    @Test
    public void getThunderIcon() {
        DetailsPresenter presenter = new DetailsPresenter(view);
        int icon = 0;

        icon = presenter.getThunderIcon(200,false);

        Assert.assertNotEquals(0,icon);
    }

    @Test
    public void isSunUp() {
        DetailsPresenter presenter = new DetailsPresenter(view);
        boolean isSunNow = false;
        boolean isSunTest;
        int currentHour;

        Calendar rightNow = Calendar.getInstance();
        currentHour = rightNow.get(Calendar.HOUR_OF_DAY);

        if (currentHour > 6 && currentHour < 19){
            isSunNow = true;
        }

        isSunTest = presenter.isSunUp();

        Assert.assertEquals(isSunNow, isSunTest);
    }
}