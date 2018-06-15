package singletonpattern_6;

/**
 * 普通懒汉
 *
 * @author nqh 2018/6/15
 */
public class SingleUtil {
    private static SingleUtil instance;

    private SingleUtil() {
    }

    public static SingleUtil getInstance() {
        if (null == instance) {
            instance = new SingleUtil();
        }
        return instance;
    }
}
