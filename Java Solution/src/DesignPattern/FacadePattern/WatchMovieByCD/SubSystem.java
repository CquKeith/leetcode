package DesignPattern.FacadePattern.WatchMovieByCD;

/**
 * @author chenmengliang
 * @date 2019/10/10 11:12
 **/
public class SubSystem {

    private String CD;

    public void turnOnTV(){
        System.out.println("Turn On TV....");
    }



    public void setCD(String CD){
        this.CD = CD;
        System.out.println("Set CD:"+CD);
    }

    public String getCD(){
        return this.CD;
    }

    public void playCD(){
        System.out.println("Playing CD:"+CD);
    }

}
