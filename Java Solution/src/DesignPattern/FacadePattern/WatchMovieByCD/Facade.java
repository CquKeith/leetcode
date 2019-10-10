package DesignPattern.FacadePattern.WatchMovieByCD;

/**
 * @author chenmengliang
 * @date 2019/10/10 11:14
 **/
public class Facade {

    private SubSystem subSystem;


    public Facade() {
        this.subSystem = new SubSystem();
    }

    public void watchMovie(){
        subSystem.turnOnTV();
        subSystem.setCD("盗梦空间");
        subSystem.playCD();
    }
}
