package LoadImageTool;

/**
 * @author nqh 2018/6/4
 */
public class ProxyImageLoader implements ImageLoader {
    private RealImageLoader realImageLoader;
    private String mFileSource;

    public ProxyImageLoader(String mFileSource) {
        this.mFileSource = mFileSource;
    }

    @Override
    public void display() {
        if (realImageLoader == null) {
            realImageLoader = new RealImageLoader(mFileSource);
        }
        realImageLoader.display();
    }
}
