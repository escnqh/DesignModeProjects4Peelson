package LoadTool;

public class StartLoadLoadState implements LoadState {

    @Override
    public void doAction(LoadFileContext loadFileContext) {
        if (!loadFileContext.isLoadFinished()){
            System.out.println("Load start from:"+loadFileContext.getSource());
            loadFileContext.setLoadState(new LoadingState());
            loadFileContext.getLoadState().doAction(loadFileContext);
        }else {
            System.out.println("Load error in start");
        }
    }
}
