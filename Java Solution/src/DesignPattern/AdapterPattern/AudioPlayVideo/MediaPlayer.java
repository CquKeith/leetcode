package DesignPattern.AdapterPattern.AudioPlayVideo;

/**
 * @author chenmengliang
 * @date 2019/10/921:58
 **/
public interface MediaPlayer {
    /**
     *
     * @param audioType 类型
     * @param fileName  文件名
     */
    void play(String audioType,String fileName);
}
