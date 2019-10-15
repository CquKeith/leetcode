package DesignPattern.ObserverPattern.WeatherForecastUpdate;

/**
 * @author chenmengliang
 * @date 2019/10/15 21:54
 **/
public class WeatherStation {
    public static void main(String[] args) {

        WeatherData weatherData = new WeatherData();

        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        CurrentDisplay currentDisplay = new CurrentDisplay(weatherData);

        weatherData.setMeasurements(1,2,3);
        weatherData.setMeasurements(100,200,300);


    }
}
