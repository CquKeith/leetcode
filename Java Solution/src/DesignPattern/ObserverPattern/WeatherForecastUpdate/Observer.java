package DesignPattern.ObserverPattern.WeatherForecastUpdate;

/**
 * @author chenmengliang
 * @date 2019/10/1521:43
 **/
public interface Observer {
    // 观察者更新自己的状态
    void update(float temperature,float humidity,float pressure);
}
