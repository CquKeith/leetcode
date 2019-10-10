package DesignPattern.MediatorPattern.CoffeePot;

/**
 * @author chenmengliang
 * @date 2019/10/10 10:17
 **/
public class ConcreteMediator extends Mediator {

    private AlarmColleague alarmColleague;
    private CoffeePotColleague coffeePotColleague;
    private CalendarColleague calendarColleague;
    private SprinklerColleague sprinklerColleague;

    public ConcreteMediator(AlarmColleague alarmColleague, CoffeePotColleague coffeePotColleague, CalendarColleague calendarColleague, SprinklerColleague sprinklerColleague) {
        this.alarmColleague = alarmColleague;
        this.coffeePotColleague = coffeePotColleague;
        this.calendarColleague = calendarColleague;
        this.sprinklerColleague = sprinklerColleague;
    }

    @Override
    void doEvent(EventTypeEnum eventType) {
        switch (eventType) {
            case ALARM:
                doAlarmEvent();
                break;
            case CALENDAR:
                doCalendarEvent();
                break;
            case COFFEEPOT:
                doCoffeePotEvent();
                break;
            case SPRINKLER:
                doSprinklerEvent();
                break;
            default:
                break;
        }
    }

    public void doAlarmEvent() {

        System.out.println("mediator do AlarmEvent:");

        alarmColleague.doAlarm();
        calendarColleague.doCalendar();
        coffeePotColleague.doCaffeePot();
        sprinklerColleague.doSprinkler();

    }

    public void doCoffeePotEvent() {

    }

    public void doCalendarEvent() {

    }

    public void doSprinklerEvent() {

    }

}
