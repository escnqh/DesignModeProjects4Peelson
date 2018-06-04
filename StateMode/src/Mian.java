import LoadTool.LoadFileContext;

/**
 * @author nqh 2018/6/4
 */
class Mian {
    public static void main(String[] args){
        LoadFileContext loadFileContext=new LoadFileContext();
        loadFileContext.startLoad("https://www.baidu.com");
    }
}
