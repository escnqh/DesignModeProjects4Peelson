import LoadImageTool.ImageLoader;
import LoadImageTool.ProxyImageLoader;

/**
 * @author nqh 2018/6/4
 */
class Mian {
    public static void main(String[] args) {
        ImageLoader imageLoader = new ProxyImageLoader("textImage.jpg");
        imageLoader.display();
        System.out.println("");
        imageLoader.display();
    }
}
