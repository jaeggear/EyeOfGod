package com.simon.eog.test.print;


import com.alibaba.fastjson.JSON;

/**
 * @author zhouzhenyong
 * @since 2017/6/19.
 */
public class Print {
    public void show(Object... data){
        if(data == null){
            show("null");
        }
        if(data instanceof Object[]){
            for(Object item: (Object[])data){
                System.out.println(JSON.toJSONString(item));
            }
        }else{
            System.out.println(JSON.toJSONString(data));
        }
    }

    public void tab(){
        show("********************************************");
    }

    public void tab(Object data){
        if(data != null) {
            show("******************" + JSON.toJSONString(data) + "******************");
        }else {
            tab("null");
        }
    }
}
