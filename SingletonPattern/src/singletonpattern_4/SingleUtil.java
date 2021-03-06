package singletonpattern_4;

/**
 * 饿汉
 *
 * @author nqh 2018/6/15
 */
public class SingleUtil {
    private SingleUtil() {
    }

    //类加载时就初始化，如果没有使用，浪费内存
    private static final SingleUtil instance = new SingleUtil();

    public static SingleUtil getInstance() {
        return instance;
    }
}
