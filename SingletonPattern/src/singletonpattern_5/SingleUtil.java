package singletonpattern_5;

/**
 * 枚举
 * 自动支持序列化机制，绝对防止多次实例化。
 *
 * @author nqh 2018/6/15
 */
public enum SingleUtil {
    INSTANCE;

    private SingleUtil() {
    }
}
