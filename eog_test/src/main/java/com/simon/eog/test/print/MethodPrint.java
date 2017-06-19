package com.simon.eog.test.print;

import java.lang.reflect.Method;

/**
 * @author zhouzhenyong
 * @since 2017/6/19.
 */
public class MethodPrint extends AbstractClassPrint {
    public void printDeclared(Object data) {
        p.tab("FieldPrint.printDeclared");
        Method[] methods = data.getClass().getDeclaredMethods();
        for (Method method : methods) {
            p.show(method.getName());
        }
    }

    public void printPublic(Object data) {
        p.tab("FieldPrint.printDeclared");
        Method[] methods = data.getClass().getMethods();
        for (Method method : methods) {
            p.show(method.getName());
        }
    }
}
