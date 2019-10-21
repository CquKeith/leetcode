package DesignPattern.ProxyPattern.ImageLoaderVirtualProxy;

/**
 * @author chenmengliang
 * @date 2019/10/17 15:18
 **/
public class ImageProxy implements Image {

    private HighResolutionImage image;

    public ImageProxy(HighResolutionImage image) {
        this.image = image;
    }

    @Override
    public void showImage() {
        while (!image.isLoad()){
            System.out.println("Temp Image : "+image.getHeight()+" "+image.getWidth());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        image.showImage();
    }
}
