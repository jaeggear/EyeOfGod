package com.simon.eog.test.common;

import com.simon.eog.test.base.BaseTest;
import org.junit.Test;


/**
 * @author zhouzhenyong
 * @since 2017/6/19.
 */
public class testFun extends BaseTest {
    @Test
    public void test_final_1(){
        final A a = new A();
        tab("修改前");
        show(a.getName());
        a.setName("nihao");
        tab("修改后");
        show(a.getName());
    }
}

class A{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String name = "zhou";
}