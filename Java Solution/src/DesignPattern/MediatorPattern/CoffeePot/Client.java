package DesignPattern.MediatorPattern.CoffeePot;

/**
 * @author chenmengliang
 * @date 2019/10/10 10:35
 **/
public class Client {
    public static void main(String[] args) {
        AlarmColleague alarmColleague = new AlarmColleague();
        CoffeePotColleague coffeePotColleague = new CoffeePotColleague();
        CalendarColleague calendarColleague = new CalendarColleague();
        SprinklerColleague sprinklerColleague = new SprinklerColleague();


        Mediator mediator = new ConcreteMediator(alarmColleague,coffeePotColleague,calendarColleague,sprinklerColleague);

        alarmColleague.onEvent(mediator);

    }
}
