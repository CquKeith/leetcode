package DesignPattern.MediatorPattern.CoffeePot;

/**
 * @author chenmengliang
 * @date 2019/10/10 10:20
 **/
public class CalendarColleague extends AbstractColleague {
    @Override
    void onEvent(Mediator mediator) {
        mediator.doEvent(EventTypeEnum.CALENDAR);
    }

    public void doCalendar(){
        System.out.println("Do Calendar()...");
    }

}
