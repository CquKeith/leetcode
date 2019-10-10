package DesignPattern.MediatorPattern.CoffeePot;

/**
 * @author chenmengliang
 * @date 2019/10/10 10:20
 **/
public class CoffeePotColleague extends AbstractColleague {
    @Override
    void onEvent(Mediator mediator) {
        mediator.doEvent(EventTypeEnum.COFFEEPOT);
    }

    public void doCaffeePot(){
        System.out.println("Do CoffeePot()...");
    }

}
