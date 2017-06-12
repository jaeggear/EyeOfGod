package com.simon.eyeofgod.common.util;

/**
 * @author zhouzhenyong
 * @since 2017/6/12.
 */
public class TypeUtil {
    /**
     * 专门用于解析json对应的string到界面回车的显示
     *
     * @return
     */
    public static String parseJson(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean spaceFlag = false;
        boolean leftFlag = false;   //[]这个括号内部的逗号不替换
        char[] charList = str.toCharArray();
        int leftCout = 0;
        for (int i = 0; i < charList.length; i++) {
            char c = charList[i];
            if (c == ',') {
                if(leftFlag){
                    stringBuilder.append(c);
                    continue;      //表示当前处于是数组中的逗号，这个时候不关心
                }
                stringBuilder.append(",\n");
                if (spaceFlag) {
                    stringBuilder.append(addSpace(leftCout));
                }
            } else if (c == '{') {
                stringBuilder.append("\n");
                if (spaceFlag) {
                    stringBuilder.append(addSpace(leftCout));
                }
                spaceFlag = true;
                stringBuilder.append("{\n");
                leftCout ++;
                if (spaceFlag) {
                    stringBuilder.append(addSpace(leftCout));
                }
            } else if (c == '}') {
                leftCout--;
                stringBuilder.append("\n");
                if (spaceFlag) {
                    stringBuilder.append(addSpace(leftCout));
                }
                stringBuilder.append("}");
            } else if(c == '['){
                leftFlag = true;
                stringBuilder.append(c);
            } else if(c == ']'){
                leftFlag = false;
                stringBuilder.append(c);
            }
            else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    public static String addSpace(int count){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<count;i++){
            stringBuilder.append("     ");
        }
        return stringBuilder.toString();
    }
}
