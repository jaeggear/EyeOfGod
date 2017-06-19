package com.simon.eog.test.print;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Field;

/**
 * @author zhouzhenyong
 * @since 2017/6/19.
 */
public class FieldPrint extends AbstractClassPrint {
    public void printDeclared(Object data) {
        p.tab("FieldPrint.printDeclared");
        Field[] fields = data.getClass().getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                p.show(field.getName() + ":  " + JSON.toJSONString(field.get(data)));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void printPublic(Object data) {
        p.tab("FieldPrint.printPublic");
        Field[] fields = data.getClass().getFields();
        try {
            for (Field field : fields) {
                p.show(field.getName() + ":  " + field.get(data));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
