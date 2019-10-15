package DesignPattern.ObserverPattern.WeatherForecastUpdate;

/**
 * @author chenmengliang
 * @date 2019/10/15 21:52
 **/
public class StatisticsDisplay implements Observer {

    public StatisticsDisplay(Subject weatherData) {
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        System.out.println("StatisticsDisplay Update: "+temperature+" "+humidity+" "+pressure);
    }
}
