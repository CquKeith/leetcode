package DesignPattern.ObserverPattern.WeatherForecastUpdate;

/**
 * @author chenmengliang
 * @date 2019/10/1521:44
 **/
public interface Subject {

    void registerObserver(Observer observer);

    boolean removeObserver(Observer observer);

    void notifyAllObservers();
}
