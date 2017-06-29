import com.simon.eog.test.base.BaseTest;
import groovy.lang.GroovyShell;

/**
 * @author zhouzhenyong
 * @since 2017/6/28.
 */
public class GroovyShellTest extends BaseTest {
    public void testGroovyShellCache(){
        GroovyShell groovyShell = new GroovyShell();
        while (true){
            groovyShell.parse("asdf");
            show("groovyShell :" + groovyShell.getClassLoader().getLoadedClasses().length);
            groovyShell.getClassLoader().clearCache();
            try {
                Thread.sleep(120000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void testEogGroovy(){
        EogClassLoader eogClassLoader = new EogClassLoader();
        while (true) {
            eogClassLoader.doParseClass();
            show("开始加载jp");
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void testPrintGroovyClassLoader(){
        GroovyShell groovyShell = new GroovyShell();
        Class cl = groovyShell.getClass();
        while (cl != null){
            show(cl);
            cl = cl.getSuperclass();
        }
    }
}
