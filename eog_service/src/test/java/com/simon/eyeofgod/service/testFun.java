package com.simon.eyeofgod.service;


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhouzhenyong
 * @since 2017/6/12.
 */
public class testFun extends BaseTest{
    @Test
    public void testHashMap_1(){
        HashMap hashMap = new HashMap();
        hashMap.put(123, "123str");
    }

    @Test
    public void testConcurrentHashMap_1(){
        Map dataMap = new ConcurrentHashMap();
    }
}
