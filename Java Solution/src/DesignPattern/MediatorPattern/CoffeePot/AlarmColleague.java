package DesignPattern.MediatorPattern.CoffeePot;

/**
 * @author chenmengliang
 * @date 2019/10/10 10:20
 **/
public class AlarmColleague extends AbstractColleague {
    @Override
    void onEvent(Mediator mediator) {
        mediator.doEvent(EventTypeEnum.ALARM);
    }

    public void doAlarm(){
        System.out.println("Do Alarm()...");
    }

}
