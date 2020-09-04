package com.example.weatherapp.ui.details;

import com.example.weatherapp.R;

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
        int weatherCode;

        code = code / 100;

        switch (code){
            case 2:
                weatherCode = getThunderIcon(code, isForecast);
                break;
            case 3:
                weatherCode = getDrizzleIcon(code, isForecast);
                break;
            case 5:
                weatherCode = getRainIcon(code, isForecast);
                break;
            case 6:
                weatherCode = getSnowIcon(code, isForecast);
                break;
            case 7:
                weatherCode = getCloudyIcon(code, isForecast);
                break;
            case 8:
                weatherCode = getSunnyIcon(code, isForecast);
                break;
            default:
                weatherCode = R.drawable.no_weather_101;
        }

        if (isForecast){
            mView.setForecastWeatherIcon(weatherCode);
        } else {
            mView.setCurrentWeatherIcon(weatherCode);
        }
    }

    private int getSunnyIcon(int code, boolean isForecast) {
        if (code == 800){
            if (isSunUp() || isForecast){
                code = R.drawable.weather_810d;
            } else {
                code = R.drawable.weather_810n;
            }
        } else if (code == 801 || code == 802) {
            if (isSunUp() || isForecast){
                code = R.drawable.weather_820d;
            } else {
                code = R.drawable.weather_820n;
            }
        } else if (code == 803) {
            if (isSunUp() || isForecast){
                code = R.drawable.weather_830d;
            } else {
                code = R.drawable.weather_830n;
            }
        } else {
            if (isSunUp() || isForecast){
                code = R.drawable.weather_840d;
            } else {
                code = R.drawable.weather_840n;
            }
        }

        return code;
    }

    private int getCloudyIcon(int code, boolean isForecast) {
        if (isSunUp() || isForecast){
            code = R.drawable.weather_710d;
        } else {
            code = R.drawable.weather_710n;
        }

        return code;
    }

    private int getSnowIcon(int code, boolean isForecast) {
        if (code == 600 || code == 610 || code == 621){
            if (isSunUp() || isForecast){
                code = R.drawable.weather_610d;
            } else {
                code = R.drawable.weather_610n;
            }
        } else if (code == 601 || code == 602 || code == 622 || code == 623){
            if (isSunUp() || isForecast){
                code = R.drawable.weather_620d;
            } else {
                code = R.drawable.weather_620n;
            }
        } else {
            if (isSunUp() || isForecast){
                code = R.drawable.weather_630d;
            } else {
                code = R.drawable.weather_630n;
            }
        }

        return code;
    }

    private int getRainIcon(int code, boolean isForecast) {
        if (code == 500 || code == 501 || code == 511 || code == 520){
            if (isSunUp() || isForecast){
                code = R.drawable.weather_501d;
            } else {
                code = R.drawable.weather_501n;
            }
        } else if (code == 502){
            if (isSunUp() || isForecast){
                code = R.drawable.weather_520d;
            } else {
                code = R.drawable.weather_520n;
            }
        } else{
            if (isSunUp() || isForecast){
                code = R.drawable.weather_530d;
            } else {
                code = R.drawable.weather_530n;
            }
        }
        return code;
    }

    private int getDrizzleIcon(int code, boolean isForecast) {
        if (isSunUp() || isForecast){
            code = R.drawable.weather_301d;
        } else {
            code = R.drawable.weather_301n;
        }
        return code;
    }

    private int getThunderIcon(int code, boolean isForecast) {
        if (code % 10 != 0){
            if (isSunUp() || isForecast){
                code = R.drawable.weather_201d;
            } else {
                code = R.drawable.weather_201n;
            }

        } else {
            if (isSunUp() || isForecast){
                code = R.drawable.weather_230d;
            } else {
                code = R.drawable.weather_230n;
            }
        }
        return code;
    }

    private boolean isSunUp() {
        int currentHour;

        Calendar rightNow = Calendar.getInstance();
        currentHour = rightNow.get(Calendar.HOUR_OF_DAY);

        if (currentHour > 6 && currentHour < 19){
            return true;
        }

        return false;
    }
}
