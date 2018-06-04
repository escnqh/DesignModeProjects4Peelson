package LoadTool;

/**
 * @author nqh 2018/6/4
 */
public class LoadFileContext {
    /**
     * 下载流程状态：
     */
    private boolean mLoadFinished = false;
    private String mSource;
    private LoadState loadState;

    public LoadFileContext() {
        loadState = null;
    }

    public void setLoadState(LoadState loadState) {
        this.loadState = loadState;
    }

    public LoadState getLoadState() {
        return loadState;
    }


    public boolean isLoadFinished() {
        return mLoadFinished;
    }

    public void setLoadFinished(boolean mLoadFinished) {
        this.mLoadFinished = mLoadFinished;
    }

    public String getSource() {
        return mSource;
    }

    public void setSource(String mSource) {
        this.mSource = mSource;
    }

    public void startLoad(String mSource){
        this.mSource=mSource;
        StartLoadLoadState startLoadLoadState=new StartLoadLoadState();
        this.setLoadState(startLoadLoadState);
        this.getLoadState().doAction(this);
    }
}
