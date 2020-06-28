import LoadImageTool.IImageLoader;
import LoadImageTool.ProxyImageLoader;

/**
 * @author nqh 2018/6/4
 */
class Main {
    public static void main(String[] args) {
        IImageLoader imageLoader = new ProxyImageLoader("textImage.jpg");
        imageLoader.display();
        System.out.println("");
        imageLoader.display();
    }
}
