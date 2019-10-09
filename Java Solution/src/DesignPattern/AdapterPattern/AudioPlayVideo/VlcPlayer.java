package DesignPattern.AdapterPattern.AudioPlayVideo;

/**
 * @author chenmengliang
 * @date 2019/10/9 22:08
 **/
public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVLC(String fileName) {
        System.out.println("Playing vlc file. Name"+fileName);
    }

    @Override
    public void playMp4(String fileName) {

    }
}
