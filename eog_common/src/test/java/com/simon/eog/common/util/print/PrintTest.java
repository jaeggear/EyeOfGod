package com.simon.eog.common.util.print;

import com.simon.eog.test.print.Print;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouzhenyong
 * @since 2017/6/19.
 */
public class PrintTest {
    private Print p = new Print();

    @Test
    public void testObject_1(){
        String str = new String();
        p.show(str);
    }

    @Test
    public void testObject_2(){
        String str = null;
        p.show(str);
    }

    @Test
    public void testObject_3(){
        List strList = new ArrayList();
        strList.add("你好");
        strList.add("zhou ");
        p.show(strList);
    }

    @Test
    public void testObject_4(){
        List strList = new ArrayList();
        strList.add("你好");
        strList.add("zhou ");
        String name = "my name is zhou";
        String address = "hangzhou ";
        p.tab();
        p.show(strList, name, address);
    }
}
