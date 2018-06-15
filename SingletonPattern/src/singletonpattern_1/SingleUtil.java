package singletonpattern_1;

/**
 * @author nqh 2018/6/15
 */
public class SingleUtil {

    private static SingleUtil instance;

    //私有构造方法
    private SingleUtil() {
    }

    //加synchronized锁保证线程安全
    public static synchronized SingleUtil getInstance() {
        //验证对象是否实例化
        if (instance == null) {
            instance = new SingleUtil();
        }
        return instance;
    }
}
