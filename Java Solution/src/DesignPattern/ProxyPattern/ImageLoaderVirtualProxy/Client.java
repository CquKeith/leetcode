package DesignPattern.ProxyPattern.ImageLoaderVirtualProxy;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author chenmengliang
 * @date 2019/10/17 15:14
 **/
public class Client {
    public static void main(String[] args) throws MalformedURLException {

        String image = "https://github.com/CyC2018/CS-Notes/raw/master/notes/pics/9b679ff5-94c6-48a7-b9b7-2ea868e828ed.png";
        URL url = new URL(image);

        HighResolutionImage highResolutionImage = new HighResolutionImage(url);

        ImageProxy imageProxy = new ImageProxy(highResolutionImage);

        imageProxy.showImage();

    }
}
