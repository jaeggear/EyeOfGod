package com.simon.eyeofgod.service;


import com.alibaba.fastjson.JSON;
import com.simon.eog.test.base.BaseTest;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhouzhenyong
 * @since 2017/6/12.
 */
public class testServiceFun extends BaseTest {
    @Test
    public void testHashMap_1(){
        HashMap hashMap = new HashMap();
        hashMap.put(123, "123str");
    }

    @Test
    public void testConcurrentHashMap_1(){
        Map dataMap = new ConcurrentHashMap();
    }

    class Term{
        public transient String name = "asdf";
        public  String address = "hanghzou";
        private sun.misc.Unsafe U;
    }

    @Test
    public void testTransient_1(){
        Term term = new Term();
        tab();
        show(JSON.toJSONString(term));
        tab();
    }
}
