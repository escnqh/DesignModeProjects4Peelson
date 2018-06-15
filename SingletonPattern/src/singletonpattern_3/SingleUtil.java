package singletonpattern_3;

/**
 * @author nqh 2018/6/15
 */
public class SingleUtil {
    private volatile static SingleUtil singleUtil;

    private SingleUtil() {
    }

    public static SingleUtil getInstance() {
        if (null == singleUtil) {
            synchronized (SingleUtil.class) {
                if (null == singleUtil) {
                    singleUtil = new SingleUtil();
                }
            }
        }
        return singleUtil;
    }
}
