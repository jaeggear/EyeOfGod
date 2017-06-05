package common;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zhouzhenyong on 2017/6/4.
 */
public class StringCompare {
    private static final int EQUAL_MAX_COUNT = 2;

    private List deletePool;
    private List addPool;

    public StringCompare() {
        deletePool = new LinkedList();
        addPool = new LinkedList();
    }

    public String compare(String oldStr, String newStr) {
        setCompare(oldStr, newStr);
        return compareResult();
    }

    /**
     * 结果转换字符串
     *
     * @return
     */
    public String compareResult() {
        StringBuilder strResult = new StringBuilder();
        if (deletePool.size() > 0) {
            strResult.append("删除：");
            for (Object data : deletePool) {
                strResult.append(data+"\n");
            }
        }

        if (addPool.size() > 0) {
            strResult.append("新增：");
            for (Object data : addPool) {
                strResult.append(data+"\n");
            }
        }
        return strResult.toString();
    }

    private void setCompare(String oldText, String newText) {
        //首先文本转换为按照行索引的数组
        String[] oldStrs = oldText.split("\n");
        String[] newStrs = newText.split("\n");

        strsCompare(oldStrs, newStrs);
    }

    public void strsCompare(String[] oldStrs, String[] newStrs) {
        List deleteTemPool = new LinkedList();
        List addTemPool = new LinkedList();
        List equalDeleteTemPool = new LinkedList();
        List equalAddTemPool = new LinkedList();

        int equalCount = 0;
        int jTerm = 0;
        for (int i = 0; i < oldStrs.length; ) {
            for (int j = jTerm; j < newStrs.length; ) {
                if (!oldStrs[i].equals(newStrs[j])) {
                    jTerm = j;
                    equalCount = 0;
                    if(equalDeleteTemPool.size() > 0){
                        deleteTemPool.addAll(equalDeleteTemPool);
                    }
                    if(equalAddTemPool.size() > 0){
                        addTemPool.addAll(equalAddTemPool);
                    }
                    addTemPool.add(generateDataStr(j, newStrs[j]));
                    int k;
                    for(k = j+1; k < newStrs.length; k++){
                        if (!oldStrs[i].equals(newStrs[k])) {
                            addTemPool.add(generateDataStr(k, newStrs[k]));
                        }else {
                            break;
                        }
                    }
                    j = k;
                } else {
                    equalDeleteTemPool.add(generateDataStr(i,oldStrs[i]));
                    equalAddTemPool.add(generateDataStr(i,newStrs[i]));
                    i++;j++;
                    equalCount ++;
                    if(equalCount >= EQUAL_MAX_COUNT){
                        equalDeleteTemPool.clear();
                        equalAddTemPool.clear();
                        insertAddPool(addTemPool);
                        insertDeletePool(deleteTemPool);
                        equalCount = 0;
                    }
                }
            }
        }
        insertAddPool(addTemPool);
    }

//    public void insertOtherDeleteData(int deleteIndex, String[] oldStrs){
//        for(int i = deleteIndex+1; i < oldStrs.length; i++){
//            deletePool.add(generateDataStr(i,oldStrs[i]));
//        }
//    }

    public void insertAddPool(List dataList){
        if(dataList.size() > 0){
            addPool.addAll(dataList);
            dataList.clear();
        }
    }

    public void insertDeletePool(List dataList){
        if(dataList.size() > 0){
            deletePool.addAll(dataList);
            dataList.clear();
        }
    }

    public String generateDataStr(int index, String data){
        return index+" 行："+data;
    }
}
