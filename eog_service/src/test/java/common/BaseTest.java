package common;


import com.simon.eyeofgod.common.string.StringCompare;
import org.junit.Test;

/**
 * Created by zhouzhenyong on 2017/6/4.
 */
public class BaseTest {
    private StringCompare stringCompare = new StringCompare();

    public void show(Object ob){
        if(ob == null){
            System.out.println("null");
            return;
        }
        System.out.println(ob);
    }
    @Test
    public void testCommon_1(){
        String oldText ="if(tongdun.12){\n" +
                "\tdataMap.put(\"G_DECISION\",\"123\")\n" +
                "\tdataMap.put(\"G_INFO\",\"132\")\n" +
                "}\n" +
                "\n" +
                "class resultDef{\n" +
                "\tprivate String riskType;\n" +
                "\tprivate String riskTerm;\n" +
                "}";
        String newText = "if(tongdun.12){\n" +
                "\tdataMap.put(\"G_DECISION\",\"123\")\n" +
                "\tdataMap.put(\"G_INFO\",\"132\")\n" +
                "}\n" +
                "\n" +
                "class resultDef{\n" +
                "\tprivate String riskType;\n" +
                "\tprivate String riskTerm;\n" +
                "\tprivate String alertType;\n" +
                "}";
        String compareResult = stringCompare.compare(oldText, newText);
        show(compareResult);
    }

    @Test
    public void testCommon_2(){
        String oldText ="if(tongdun.12){\n" +
                "\tdataMap.put(\"G_DECISION\",\"123\")\n" +
                "\tdataMap.put(\"G_INFO\",\"132\")\n" +
                "}\n" +
                "\n" +
                "class resultDef{\n" +
                "\tprivate String riskType;\n" +
                "\tprivate String riskTerm;\n" +
                "}";
        String newText = "if(tongdun.12){\n" +
                "\tdataMap.put(\"G_DECISION\",\"123\")\n" +
                "}\n" +
                "\n" +
                "class resultDef{\n" +
                "\tprivate String riskTerm;\n" +
                "\tprivate String alertType;\n" +
                "}";
        String compareResult = stringCompare.compare(oldText, newText);
        show(compareResult);
    }

    @Test
    public void testCommon_3(){
        String oldText ="if(tongdun.12){\n" +
                "\tdataMap.put(\"G_DECISION\",\"123\")\n" +
                "\tdataMap.put(\"G_INFO\",\"132\")\n" +
                "}\n" +
                "\n" +
                "class resultDef{\n" +
                "\tprivate String riskType;\n" +
                "\tprivate String riskTerm;\n" +
                "}";
        String newText = "if(tongdun.12){\n" +
                "\tdataMap.put(\"G_DECISION\",\"123\")\n" +
                "\tdataMap.put(\"G_INFO\",\"132\")\n" +
                "\tprivate String alertType2;\n" +
                "\tprivate String alertType3;\n" +
                "}\n" +
                "\n" +
                "class resultDef{\n" +
                "\tprivate String riskType;\n" +
                "\tprivate String riskTerm;\n" +
                "\tprivate String alertType;\n" +
                "\tprivate String alertType;\n" +
                "}";
        String compareResult = stringCompare.compare(oldText, newText);
        show(compareResult);
    }
}
