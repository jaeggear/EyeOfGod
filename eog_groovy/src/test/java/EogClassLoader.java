/**
 * @author zhouzhenyong
 * @since 2017/6/28.
 */
public class EogClassLoader {
    public EogClassLoader(){

    }
    private EogClassCollector eogClassCollector;
    public static class InnerEogClassLoader extends EogClassLoader{
        private final EogClassLoader delete;
        public InnerEogClassLoader(EogClassLoader eogClassLoader){
            super();
            delete = eogClassLoader;
        }
    }

    public static class EogClassCollector{
        private final EogClassLoader cl;
        public EogClassCollector(EogClassLoader delete){
            cl = delete;
        }
    }

    public void doParseClass(){
        InnerEogClassLoader innerEogClassLoader = new InnerEogClassLoader(this);
        EogClassCollector eogClassCollector = new EogClassCollector(innerEogClassLoader);
        this.eogClassCollector = eogClassCollector;
    }
}
