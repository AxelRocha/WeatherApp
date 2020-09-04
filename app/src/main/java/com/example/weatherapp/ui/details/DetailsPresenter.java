package com.example.weatherapp.ui.details;

import com.example.weatherapp.R;
import com.example.weatherapp.model.WeatherAssets;

import java.util.Calendar;

public class DetailsPresenter implements DetailsContract.Presenter {

    private final DetailsContract.View mView;

    public DetailsPresenter(DetailsContract.View mView) {
        this.mView = mView;
        this.mView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void redoSearch() {
        mView.returnToSearchActivity();
    }

    @Override
    public void getWeatherIcon(int code, boolean isForecast) {
        WeatherAssets weatherAssets = new WeatherAssets();

        switch (code / 100){
            case 2:
                weatherAssets = getThunderAssets(code, isForecast);
                break;
            case 3:
                weatherAssets = getDrizzleAssets(code, isForecast);
                break;
            case 5:
                weatherAssets = getRainAssets(code, isForecast);
                break;
            case 6:
                weatherAssets = getSnowAssets(code, isForecast);
                break;
            case 7:
                weatherAssets = getCloudyAssets(code, isForecast);
                break;
            case 8:
                weatherAssets = getSunnyAssets(code, isForecast);
                break;
            default:
                weatherAssets.setWeatherIcon(R.drawable.no_weather_101);
                weatherAssets.setWeatherBackground(R.drawable.curve_border);
        }

        updateView(weatherAssets, isForecast);
    }

    WeatherAssets getThunderAssets(int code, boolean isForecast) {
        int icon;
        WeatherAssets weatherAssets = new WeatherAssets();

        if (code == 200 || code == 201 || code == 202){
            if (isSunUp() || isForecast){
                icon = R.drawable.weather_201d;
            } else {
                icon = R.drawable.weather_201n;
            }

        } else if (code == 230 || code == 231 || code == 232 || code == 233){
            if (isSunUp() || isForecast){
                icon = R.drawable.weather_230d;
            } else {
                icon = R.drawable.weather_230n;
            }
        } else {
            icon = R.drawable.no_weather_101;
        }

        weatherAssets.setWeatherIcon(icon);
        weatherAssets.setWeatherBackground(R.drawable.weather_gif_200);

        return weatherAssets;
    }

    WeatherAssets getDrizzleAssets(int code, boolean isForecast) {
        int icon;
        WeatherAssets weatherAssets = new WeatherAssets();

        if (code == 300 || code == 301 || code == 302){
            if (isSunUp() || isForecast){
                icon = R.drawable.weather_301d;
            } else {
                icon = R.drawable.weather_301n;
            }
        } else {
            icon = R.drawable.no_weather_101;
        }

        weatherAssets.setWeatherIcon(icon);
        weatherAssets.setWeatherBackground(R.drawable.weather_gif_300);

        return weatherAssets;
    }

    WeatherAssets getRainAssets(int code, boolean isForecast) {
        int icon;
        int background;
        WeatherAssets weatherAssets = new WeatherAssets();

        if (code == 500 || code == 501 || code == 511 || code == 520){
            background = R.drawable.weather_gif_501;
            if (isSunUp() || isForecast){
                icon = R.drawable.weather_501d;
            } else {
                icon = R.drawable.weather_501n;
            }
        } else if (code == 502){
            background = R.drawable.weather_gif_502;
            if (isSunUp() || isForecast){
                icon = R.drawable.weather_520d;
            } else {
                icon = R.drawable.weather_520n;
            }
        } else if (code == 521 || code == 522){
            background = R.drawable.weather_gif_501;
            if (isSunUp() || isForecast){
                icon = R.drawable.weather_530d;
            } else {
                icon = R.drawable.weather_530n;
            }
        } else {
            icon = R.drawable.no_weather_101;
            background = R.drawable.curve_border;
        }

        weatherAssets.setWeatherIcon(icon);
        weatherAssets.setWeatherBackground(background);

        return weatherAssets;
    }

    WeatherAssets getSnowAssets(int code, boolean isForecast) {
        int icon;
        int background;
        WeatherAssets weatherAssets = new WeatherAssets();

        if (code == 600 || code == 610 || code == 621){
            background = R.drawable.weather_gif_600;
            if (isSunUp() || isForecast){
                icon = R.drawable.weather_610d;
            } else {
                icon = R.drawable.weather_610n;
            }
        } else if (code == 601 || code == 602 || code == 622 || code == 623){
            background = R.drawable.weather_gif_600;
            if (isSunUp() || isForecast){
                icon = R.drawable.weather_620d;
            } else {
                icon = R.drawable.weather_620n;
            }
        } else if (code == 611 || code == 612){
            background = R.drawable.weather_gif_601;
            if (isSunUp() || isForecast){
                icon = R.drawable.weather_630d;
            } else {
                icon = R.drawable.weather_630n;
            }
        } else {
            icon = R.drawable.no_weather_101;
            background = R.drawable.curve_border;
        }

        weatherAssets.setWeatherIcon(icon);
        weatherAssets.setWeatherBackground(background);

        return weatherAssets;
    }

    WeatherAssets getCloudyAssets(int code, boolean isForecast) {
        int icon;
        int background;
        WeatherAssets weatherAssets = new WeatherAssets();

        if (code == 700 || code == 711 || code == 721 || code == 731 || code == 741 || code == 751){
            background = R.drawable.weather_gif_700;
            if (isSunUp() || isForecast){
                icon = R.drawable.weather_710d;
            } else {
                icon = R.drawable.weather_710n;
            }
        } else {
            icon = R.drawable.no_weather_101;
            background = R.drawable.curve_border;
        }

        weatherAssets.setWeatherIcon(icon);
        weatherAssets.setWeatherBackground(background);

        return weatherAssets;
    }

    WeatherAssets getSunnyAssets(int code, boolean isForecast) {
        int icon;
        int background;
        WeatherAssets weatherAssets = new WeatherAssets();

        if (code == 800){
            if (isSunUp() || isForecast){
                background = R.drawable.weather_gif_800d;
                icon = R.drawable.weather_810d;
            } else {
                background = R.drawable.weather_gif_800n;
                icon = R.drawable.weather_810n;
            }
        } else if (code == 801 || code == 802) {
            if (isSunUp() || isForecast){
                background = R.drawable.weather_gif_801d;
                icon = R.drawable.weather_820d;
            } else {
                background = R.drawable.weather_gif_801n;
                icon = R.drawable.weather_820n;
            }
        } else if (code == 803) {
            if (isSunUp() || isForecast){
                background = R.drawable.weather_gif_801d;
                icon = R.drawable.weather_830d;
            } else {
                background = R.drawable.weather_gif_801n;
                icon = R.drawable.weather_830n;
            }
        } else if (code == 804){
            if (isSunUp() || isForecast){
                background = R.drawable.weather_gif_801d;
                icon = R.drawable.weather_840d;
            } else {
                background = R.drawable.weather_gif_801n;
                icon = R.drawable.weather_840n;
            }
        } else {
            icon = R.drawable.no_weather_101;
            background = R.drawable.curve_border;
        }

        weatherAssets.setWeatherIcon(icon);
        weatherAssets.setWeatherBackground(background);

        return weatherAssets;
    }

    void updateView(WeatherAssets weatherAssets, boolean isForecast){
        if (isForecast){
            mView.setForecastWeatherIcon(weatherAssets.getWeatherIcon());
            mView.setForecastWeatherBackground(weatherAssets.getWeatherBackground());
        } else {
            mView.setCurrentWeatherIcon(weatherAssets.getWeatherIcon());
            mView.setCurrentWeatherBackground(weatherAssets.getWeatherBackground());
        }
    }

    boolean isSunUp() {
        int currentHour;

        Calendar rightNow = Calendar.getInstance();
        currentHour = rightNow.get(Calendar.HOUR_OF_DAY);

        if (currentHour > 6 && currentHour < 19){
            return true;
        }

        return false;
    }
}
