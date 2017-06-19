package com.simon.eog.test.print;

/**
 * @author zhouzhenyong
 * @since 2017/6/19.
 */
public class InnerClassPrint extends AbstractClassPrint {
    public void printDeclared(Object data) {
        Class[] innerClass = data.getClass().getDeclaredClasses();
        for (Class c: innerClass){
            p.show(c.getName()+":  "+c.getSimpleName());
        }
    }

    public void printPublic(Object data) {
        Class[] innerClass = data.getClass().getClasses();
        for (Class c: innerClass){
            p.show(c.getName()+":  "+c.getSimpleName());
        }
    }
}
