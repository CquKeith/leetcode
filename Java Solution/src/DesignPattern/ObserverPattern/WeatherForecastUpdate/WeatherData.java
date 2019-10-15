package DesignPattern.ObserverPattern.WeatherForecastUpdate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenmengliang
 * @date 2019/10/15 21:45
 **/
public class WeatherData implements Subject {

    private List<Observer> observers;

    // 温度
    private float temperature;
    // 湿度
    private float humidity;
    // 气压
    private float pressure;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.humidity = humidity;
        this.temperature = temperature;
        this.pressure = pressure;

        notifyAllObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public boolean removeObserver(Observer observer) {
        int index = observers.indexOf(observer);
        if (index != -1){
            observers.remove(index);
            return true;
        }
        return false;
    }

    @Override
    public void notifyAllObservers() {
        for (Observer o :
                observers) {
            o.update(temperature,humidity,pressure);
        }
    }
}
