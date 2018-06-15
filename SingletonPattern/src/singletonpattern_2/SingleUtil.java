package singletonpattern_2;

/**
 * @author nqh 2018/6/15
 */
public class SingleUtil {

    //私有构造函数
    private SingleUtil() {
    }

    public static SingleUtil getInstance() {
        return GetInstance.instance;
    }

    //利用 Java 的类加载机制，来延迟初始化对象实例。类被主动调用的时候，如果没有加载会执行加载
    //Java 的类加载过程是同步的，包括类静态成员的初始化也是同步的，这个做法无需再单独加锁
    private static class GetInstance {
        private static final SingleUtil instance = new SingleUtil();
    }
}
