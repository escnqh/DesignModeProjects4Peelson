package singletonpattern_3;

/**
 * 双锁
 *
 * @author nqh 2018/6/15
 */
public class SingleUtil {
    private volatile static SingleUtil singleUtil;

    private SingleUtil() {
    }

    public static SingleUtil getInstance() {
        //先验证需不需要同步方法，保证效率
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
