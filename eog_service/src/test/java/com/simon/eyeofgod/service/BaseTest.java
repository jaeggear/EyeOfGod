package com.simon.eyeofgod.service;

/**
 * @author zhouzhenyong
 * @since 2017/6/12.
 */
public class BaseTest {
    public void show(Object data){
        if(data == null){
            System.out.println("null");
            return;
        }
        System.out.println(data.toString());
    }
}
