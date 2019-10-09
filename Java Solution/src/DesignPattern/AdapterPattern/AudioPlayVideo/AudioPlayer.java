package DesignPattern.AdapterPattern.AudioPlayVideo;

/**
 * @author chenmengliang
 * @date 2019/10/9 21:58
 * 本来只有播放mp3的能力
 * 通过适配，将AudioPlayer获取到播放mp4和vlc视频的能力
 **/
public class AudioPlayer implements MediaPlayer {

    private AdvancedMediaPlayerAdapter adapter;

    @Override
    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("mp3")){
            System.out.println("Playing mp3:"+fileName);
            return;
        }

        if (audioType.equalsIgnoreCase("mp4") || audioType.equalsIgnoreCase("vlc")){
            adapter = new AdvancedMediaPlayerAdapter(audioType);
            adapter.play(audioType,fileName);
            return;
        }

        System.out.println("Invalid audio type:"+audioType+" format not supported yet...");

    }
}
