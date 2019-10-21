package DesignPattern.ProxyPattern.ImageLoaderVirtualProxy;

import java.net.URL;

/**
 * @author chenmengliang
 * @date 2019/10/17 15:11
 **/
public class HighResolutionImage implements Image {

    private URL imageUrl;
    private long startTime;
    private int height;
    private int width;

    public HighResolutionImage(URL imageUrl) {
        this.imageUrl = imageUrl;
        this.startTime = System.currentTimeMillis();
        this.height = 600;
        this.width = 600;
    }

    public boolean isLoad(){

        // 模拟图片加载，假设3s才加载完毕
        long endTime = System.currentTimeMillis();
        return endTime - startTime > 3000;
    }


    @Override
    public void showImage() {
        System.out.println("Real Image:"+imageUrl);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
