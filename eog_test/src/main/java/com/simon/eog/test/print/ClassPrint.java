package com.simon.eog.test.print;

/**
 * @author zhouzhenyong
 * @since 2017/6/19.
 */
public interface ClassPrint {
    /**
     * 打印当前类的行为
     */
    void printDeclared(Object data);

    /**
     * 打印类及父类的所有行为
     */
    void printPublic(Object data);
}
