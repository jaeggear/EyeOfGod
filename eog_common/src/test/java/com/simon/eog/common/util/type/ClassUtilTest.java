package com.simon.eog.common.util.type;

import com.simon.eog.test.print.*;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhouzhenyong
 * @since 2017/6/19.
 */
public class ClassUtilTest {

    private Print print = new Print();

    public void show(Object data) {
        print.show(data);
    }

    public void tab() {
        print.tab();
    }

    public void tab(Object data) {
        print.tab(data);
    }

    private ClassPrint fieldPrint = new FieldPrint();
    private ClassPrint methodPrint = new MethodPrint();
    private ClassPrint innerClassPrint = new InnerClassPrint();

    /********************   测试对属性的反射调用  ***********************/
    /**
     * 测试反射调用
     */
    @Test
    public void testReflection_1() {
        ClassUtil.invoke(new B(), "printlnA", new Class[]{String.class}, new Object[]{"test"});
        ClassUtil.invoke(new B(), "printlnB");
    }

    /**
     * 测试方法getFields 和 getDeclaredFields 的区别
     * 总结：
     * 方法getFields 返回的是当前和父类的所有的公共属性
     * 方法getDeclaredFields 返回的是当前的所有的属性，私有的，受保护的，公有的都有
     */
    @Test
    public void testField_1() {
        Class<?> b_class = B.class;
        Field[] fields = b_class.getFields();
        tab("getFields");
        for (Field field : fields) {
            show(field.toString());
        }
        tab();

        Field[] declearedField = b_class.getDeclaredFields();
        tab("getDeclaredFields");
        for (Field field : declearedField) {
            show(field.toString());
        }
        tab();
    }

    /**
     * 测试：
     * 测试通过方法获取当前类的私有属性，并赋值
     */
    @Test
    public void testField_2() {
        try {
            B b = new B();
            Class<?> b_class = b.getClass();
            Field field = b_class.getDeclaredField("b_name3");
            field.set(b, "b_insert");
            show(b.getB_name3());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试将类中的所有的属性的值打印出来
     */
    @Test
    public void testField_get() {
        B b = new B();
        try {
            Field field = b.getClass().getDeclaredField("b_name1");
            field.setAccessible(true);
            field.get(b);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试将类中的所有的属性的值打印出来
     */
    @Test
    public void testField_set() {
        B b = new B();
        try {
            Field field = b.getClass().getDeclaredField("b_name1");
            field.setAccessible(true);
            field.set(b, "123");
            show(b.getB_name1());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试反射对于复杂数据的设置
     */
    @Test
    public void testField_set_1() {
        B b = new B();

        Field field = null;
        try {
            field = b.getClass().getDeclaredField("e");
            field.setAccessible(true);
            E e = new E();
            tab("修改前");
            show(b.getE().getName());
            tab("修改后");
            e.setName("change");
            field.set(b, e);
            show(b.getE().getName());

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        }
    }

    @Test
    public void testField_get_1() {
        F f = new F();
        fieldPrint.printDeclared(f);
    }

    /**
     * 测试提取类内部的子类
     */
    @Test
    public void setField_show_innerClass_1() {
        F f = new F();
        innerClassPrint.printDeclared(f);
        innerClassPrint.printPublic(f);
    }

    /**
     * 测试： 展示内部类中的数据
     */
    @Test
    public void setField_get_innerClass_1() {
        F f = new F();
        Class<?> cs[] = f.getClass().getDeclaredClasses();
        for (Class c : cs) {
            String simpleName = c.getSimpleName();
            if (simpleName.equals("InnerF")) {
                try {
                    tab("修改前");
                    Field field = c.getDeclaredField("add");
                    show(field.get(c));
                    field.set(c, "nihao");
                    tab("修改后");
                    show(field.get(c));

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /********************   测试对方法的反射调用  ***********************/
    @Test
    public void testMethod_1() {
        B b = new B();
        try {
            Method method = b.getClass().getDeclaredMethod("showMult", String.class, Integer.class, String.class);
            try {
                method.invoke(b, "zhouzhenyong", 23, "hangzhou");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testF_1() {
        F f = new F();
//        show(F.InnerF.);
    }
}


/*****************************************************************/
class A {
    public String getA_name1() {
        return a_name1;
    }

    public void setA_name1(String a_name1) {
        this.a_name1 = a_name1;
    }

    public String getA_name2() {
        return a_name2;
    }

    public void setA_name2(String a_name2) {
        this.a_name2 = a_name2;
    }

    public String getA_name3() {
        return a_name3;
    }

    public void setA_name3(String a_name3) {
        this.a_name3 = a_name3;
    }

    private String a_name1 = "a_private_field";
    protected String a_name2 = "a_protect_field";
    public String a_name3 = "a_public_field";

    private void printlnA(String s) {
        System.out.println(s);
    }
}

class B extends A {
    private Print print = new Print();

    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }

    private E e = new E();

    public String getB_name1() {
        return b_name1;
    }

    public void setB_name1(String b_name1) {
        this.b_name1 = b_name1;
    }

    public String getB_name2() {
        return b_name2;
    }

    public void setB_name2(String b_name2) {
        this.b_name2 = b_name2;
    }

    public String getB_name3() {
        return b_name3;
    }

    public void setB_name3(String b_name3) {
        this.b_name3 = b_name3;
    }

    private String b_name1 = "b_private_field";
    protected String b_name2 = "b_protect_field";
    public String b_name3 = "b_public_field";

    private void printlnB() {
        System.out.println("b");
    }

    public void showMult(String name, Integer age, String add) {
        print.show(name);
        print.show(age);
        print.show(add);
    }
}

class E {
    private String name = "init";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


class F {
    private String name = "f_name";

    private static class InnerF {
        public static final String add = "hangzhou";
    }
}
