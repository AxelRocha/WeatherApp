package com.example.weatherapp.ui.search;

import com.example.weatherapp.model.WeatherAssets;
import com.example.weatherapp.model.requestResponses.currentWeather.CurrentWeatherRequestResponse;
import com.example.weatherapp.model.requestResponses.forecastWeather.ForecastWeatherRequestResponse;
import com.example.weatherapp.network.GetDataService;
import com.example.weatherapp.ui.details.DetailsPresenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Calendar;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
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

    @Mock
    private Callback<ForecastWeatherRequestResponse> callResponse;

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

        verify(view, times(1)).warnEmptyTextView();

        verify(retrofit, times(0)).getCurrentWeather("");
    }

    @Test
    public void searchWeather_NullResponse() {
        SearchPresenter presenter = new SearchPresenter(view);

        when(retrofit.getForecastWeather(anyString())).thenReturn(forecastCall);

        Mockito.doAnswer(new Answer() {
                             @Override
                             public Object answer(InvocationOnMock invocation) throws Throwable {

                                 Callback callback = invocation.getArgumentAt(0, Callback.class);
                                 callback.onResponse(forecastCall, Response.error(404, ResponseBody.create(null, "")));

                                 return null;
                             }
                         }
        ).when(forecastCall).enqueue(any(Callback.class));

        presenter.getForecastWeather("Cuiaba", retrofit);

        verify(view, times(1)).warnCityNotFound();
    }

    @Test
    public void searchWeather_Failure() {
        SearchPresenter presenter = new SearchPresenter(view);

        when(retrofit.getForecastWeather(anyString())).thenReturn(forecastCall);

        Mockito.doAnswer(new Answer() {
                             @Override
                             public Object answer(InvocationOnMock invocation) throws Throwable {

                                 Callback callback = invocation.getArgumentAt(0, Callback.class);
                                 callback.onFailure(forecastCall, new Exception());

                                 return null;
                             }
                         }
        ).when(forecastCall).enqueue(any(Callback.class));

        presenter.getForecastWeather("Cuiaba", retrofit);

        verify(view, times(1)).warnErrorOccurred();
    }

    @Test
    public void getSunnyIcon() {
        SearchPresenter presenter = new SearchPresenter(view);
        WeatherAssets weatherAssets;

        weatherAssets = presenter.getSunnyAssets(800, true);

        Assert.assertNotNull(weatherAssets);
        Assert.assertNotEquals(0,weatherAssets.getWeatherIcon());
        Assert.assertNotEquals(0,weatherAssets.getWeatherBackground());
    }

    @Test
    public void getCloudyIcon() {
        SearchPresenter presenter = new SearchPresenter(view);
        WeatherAssets weatherAssets;

        weatherAssets = presenter.getSunnyAssets(800, true);

        Assert.assertNotNull(weatherAssets);
        Assert.assertNotEquals(0,weatherAssets.getWeatherIcon());
        Assert.assertNotEquals(0,weatherAssets.getWeatherBackground());
    }

    @Test
    public void getSnowIcon() {
        SearchPresenter presenter = new SearchPresenter(view);
        WeatherAssets weatherAssets;

        weatherAssets = presenter.getSunnyAssets(600, true);

        Assert.assertNotNull(weatherAssets);
        Assert.assertNotEquals(0,weatherAssets.getWeatherIcon());
        Assert.assertNotEquals(0,weatherAssets.getWeatherBackground());
    }

    @Test
    public void getRainIcon() {
        SearchPresenter presenter = new SearchPresenter(view);
        WeatherAssets weatherAssets;

        weatherAssets = presenter.getSunnyAssets(500, true);

        Assert.assertNotNull(weatherAssets);
        Assert.assertNotEquals(0,weatherAssets.getWeatherIcon());
        Assert.assertNotEquals(0,weatherAssets.getWeatherBackground());
    }

    @Test
    public void getDrizzleIcon() {
        SearchPresenter presenter = new SearchPresenter(view);
        WeatherAssets weatherAssets;

        weatherAssets = presenter.getSunnyAssets(300, true);

        Assert.assertNotNull(weatherAssets);
        Assert.assertNotEquals(0,weatherAssets.getWeatherIcon());
        Assert.assertNotEquals(0,weatherAssets.getWeatherBackground());
    }


    @Test
    public void getThunderIcon() {
        SearchPresenter presenter = new SearchPresenter(view);
        WeatherAssets weatherAssets;

        weatherAssets = presenter.getSunnyAssets(200, true);

        Assert.assertNotNull(weatherAssets);
        Assert.assertNotEquals(0,weatherAssets.getWeatherIcon());
        Assert.assertNotEquals(0,weatherAssets.getWeatherBackground());
    }

    @Test
    public void isSunUp() {
        SearchPresenter presenter = new SearchPresenter(view);
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