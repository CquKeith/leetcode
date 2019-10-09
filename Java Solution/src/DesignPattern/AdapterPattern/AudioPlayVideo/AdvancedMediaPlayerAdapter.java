package DesignPattern.AdapterPattern.AudioPlayVideo;

/**
 * @author chenmengliang
 * @date 2019/10/9 22:17
 **/
public class AdvancedMediaPlayerAdapter implements MediaPlayer {

    private AdvancedMediaPlayer advancedMediaPlayer;

    public AdvancedMediaPlayerAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("mp4")){
            advancedMediaPlayer = new Mp4Player();
        }else if (audioType.equalsIgnoreCase("vlc")){
            advancedMediaPlayer = new VlcPlayer();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp4")){
            advancedMediaPlayer.playMp4(fileName);
        }else if (audioType.equalsIgnoreCase("vlc")){
            advancedMediaPlayer.playVLC(fileName);
        }
    }
}
