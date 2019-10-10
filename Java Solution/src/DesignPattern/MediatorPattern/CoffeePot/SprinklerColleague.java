package DesignPattern.MediatorPattern.CoffeePot;

/**
 * @author chenmengliang
 * @date 2019/10/10 10:20
 **/
public class SprinklerColleague extends AbstractColleague {
    @Override
    void onEvent(Mediator mediator) {
        mediator.doEvent(EventTypeEnum.SPRINKLER);
    }

    public void doSprinkler(){
        System.out.println("Do Sprinkler()...");
    }

}
