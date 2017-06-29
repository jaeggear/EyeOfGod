package com.simon.eog.test.base;

import com.simon.eog.test.print.Print;
import junit.framework.TestCase;

/**
 * @author zhouzhenyong
 * @since 2017/6/19.
 */
public class BaseTest extends TestCase {
    private Print p = new Print();
    public void show(){
        p.show();
    }
    public void show(Object... data){
        p.show(data);
    }
    public void tab(){
        p.tab();
    }
    public void tab(Object data){
        p.tab(data);
    }
}
