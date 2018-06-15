package singletonpattern_4;

/**
 * @author nqh 2018/6/15
 */
public class SingleUtil {
    private SingleUtil() {
    }

    private static final SingleUtil instance = new SingleUtil();

    public static SingleUtil getInstance() {
        return instance;
    }
}
