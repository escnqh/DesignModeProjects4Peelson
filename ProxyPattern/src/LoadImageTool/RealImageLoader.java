package LoadImageTool;

/**
 * @author nqh 2018/6/4
 */
class RealImageLoader implements IImageLoader {
    private String mFileSource;


    public RealImageLoader(String mFileSource) {
        this.mFileSource = mFileSource;
        loadFunction(mFileSource);
    }

    private void loadFunction(String mFileSource) {
        System.out.println("Loading...   :" + mFileSource);
    }

    @Override
    public void display() {
        System.out.println("Displaying...  :" + mFileSource);
    }
}
