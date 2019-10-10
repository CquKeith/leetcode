package DesignPattern.FacadePattern.WatchMovieByCD;

/**
 * @author chenmengliang
 * @date 2019/10/10 11:11
 **/
public class Client {
    public static void main(String[] args) {

        Facade facade = new Facade();

        facade.watchMovie();

    }
}
