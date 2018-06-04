package LoadTool;

/**
 * @author nqh 2018/6/4
 */
class LoadingState implements LoadState {
    @Override
    public void doAction(LoadFileContext loadFileContext) {
        if (!loadFileContext.isLoadFinished()){
            System.out.println("Loading from:"+loadFileContext.getSource());
            loadFileContext.setLoadState(new StopLoadState());
            loadFileContext.getLoadState().doAction(loadFileContext);
        }else {
            System.out.println("Load error in loading");
        }
    }
}
