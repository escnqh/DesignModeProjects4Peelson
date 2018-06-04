package LoadTool;

/**
 * @author nqh 2018/6/4
 */
class StopLoadState implements LoadState {

    @Override
    public void doAction(LoadFileContext loadFileContext) {
        if (!loadFileContext.isLoadFinished()){
            System.out.println("Loader is finished!");
            loadFileContext.setLoadFinished(true);
        }else {
            System.out.println("Load error in stop");
        }

    }
}
