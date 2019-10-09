package DesignPattern.AdapterPattern.AudioPlayVideo;

/**
 * @author chenmengliang
 * @date 2019/10/9 22:08
 **/
public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playVLC(String fileName) {
    }
    
    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name"+fileName);
    }
}
